package com.mathtrainer.backend.gateway.config.security;

import com.mathtrainer.backed.common.constants.CommonConsant;
import com.mathtrainer.backed.common.constants.URLConstant;
import com.mathtrainer.backed.common.dto.JWTPayloadDto;
import com.mathtrainer.backed.common.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // if login url then skip validate jwt
        if (URLConstant.LOGIN_URI.equals(request.getRequestURI()) ||
                URLConstant.REGISTER_URI.equals(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = getJwtFromRequest(request);
        // validate jwt
        String errMsg = JwtTokenUtil.validateToken(jwt);
        if (StringUtils.isNotEmpty(errMsg)) {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write(errMsg);
            return;
        }

        // set spring token
        JWTPayloadDto payload = JwtTokenUtil.getPayloadFromJWT(jwt);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                payload.getUsername(), null, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // add custom header and do next filter
        response.addHeader(CommonConsant.HEADER_USER_ID, payload.getUserId());
        response.addHeader(CommonConsant.HEADER_USER_NAME, payload.getUsername());
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.isNotEmpty(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return StringUtils.EMPTY;
    }
}