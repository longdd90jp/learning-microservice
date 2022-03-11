package dr.app.core.framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import dr.app.core.framework.dto.JWTPayloadDto;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Map;

public class JwtTokenUtil {
    private final static String JWT_SECRET = "HRlELXqpSB";

    private final static long JWT_EXPIRATION = 604800000L;

    public static String generateToken(JWTPayloadDto payloadDto) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        ObjectMapper objectMapper = new ObjectMapper();

        return Jwts.builder()
                .setClaims(objectMapper.convertValue(payloadDto, Map.class))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public static JWTPayloadDto getPayloadFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(claims, JWTPayloadDto.class);
    }

    public static String validateToken(String authToken) {
        String errMsg = StringUtils.EMPTY;
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
        } catch (MalformedJwtException ex) {
            errMsg = "Invalid JWT token";
        } catch (ExpiredJwtException ex) {
            errMsg = "Expired JWT token";
        } catch (UnsupportedJwtException ex) {
            errMsg = "Unsupported JWT token";
        } catch (IllegalArgumentException ex) {
            errMsg = "JWT claims string is empty";
        } catch (Exception ex) {
            errMsg = ex.getMessage();
        }
        return errMsg;
    }
}
