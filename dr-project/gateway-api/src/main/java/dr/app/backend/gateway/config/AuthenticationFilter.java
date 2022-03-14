package dr.app.backend.gateway.config;

import dr.app.core.framework.constant.CommonConsant;
import dr.app.core.framework.constant.URLConstant;
import dr.app.core.framework.dto.JWTPayloadDto;
import dr.app.core.framework.utils.JwtTokenUtil;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter implements GlobalFilter, Ordered {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        // skip check auth with some specific uri
        if(isSkipCheckAuth(request.getPath().value())) return chain.filter(exchange);

        String jwtToken = getJwtFromRequest(request);
        // validate jwt
        if (!jwtTokenUtil.verifyJWTToken(jwtToken)) {
            return this.onError(exchange, "Authorization header is invalid", HttpStatus.UNAUTHORIZED);
        }

        // add data to header to down stream service
        JWTPayloadDto payload = jwtTokenUtil.getPayloadFromJWT(jwtToken);

        ServerWebExchange modifiedExchange = exchange.mutate()
                // modify the original request:
                .request(originalRequest -> {
                    originalRequest.header(CommonConsant.HEADER_OFFICE_ID, payload.getOfficeId()).build();
                    originalRequest.header(CommonConsant.HEADER_OFFICE_USER_ID, payload.getOfficeUserId()).build();
                })
                .build();

        return chain.filter(modifiedExchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    private boolean isSkipCheckAuth(String urlPath) {
        if(URLConstant.LOGIN_URI.equals(urlPath) || URLConstant.REGISTER_URI.equals(urlPath)) {
            return true;
        }
        return false;
    }
    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add("errMsg", err);
        response.getHeaders().add("errCode", "ERROR_001");
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    private String getJwtFromRequest(ServerHttpRequest request) {
        String bearerToken = request.getHeaders().getFirst("Authorization");

        if (StringUtils.isNotEmpty(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return StringUtils.EMPTY;
    }
}