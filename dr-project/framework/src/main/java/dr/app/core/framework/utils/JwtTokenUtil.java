package dr.app.core.framework.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import dr.app.core.framework.constant.JwtAlgorithm;
import dr.app.core.framework.dto.JWTPayloadDto;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class JwtTokenUtil {

    private String secret;
    private Algorithm algorithm;
    private JwtAlgorithm algorithmName;
    private String issuer;
    private long expireInSecond;

    public JwtTokenUtil(String secret, JwtAlgorithm algorithmName, String issuer, long expireInSecond) {
        this.issuer = issuer;
        this.expireInSecond = expireInSecond;
        this.secret = secret;
        this.algorithmName = algorithmName;
        setAlgorithm();
    }

    private void setAlgorithm() {
        switch (this.algorithmName) {
            case HS256:
                this.algorithm = Algorithm.HMAC256(this.secret);
                break;
            case HS384:
                this.algorithm = Algorithm.HMAC384(this.secret);
                break;
            case HS512:
                this.algorithm = Algorithm.HMAC512(this.secret);
                break;
            default:
                this.algorithm = Algorithm.HMAC512(this.secret);
                break;
        }
    }

    public String generateToken(JWTPayloadDto payloadDto) {
        long now = new Date().getTime();
        long expireTime = now + (expireInSecond * 1000);
        Date expireDate = new Date(expireTime);

        String generatedToken = JWT.create()
                .withIssuer(issuer)
                .withClaim("officeId", payloadDto.getOfficeId())
                .withClaim("officeUserId", payloadDto.getOfficeUserId())
                .withExpiresAt(expireDate)
                .sign(algorithm);
        return generatedToken;
    }

    public boolean verifyJWTToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .acceptExpiresAt(expireInSecond)
                    .build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException ex) {
            return false;
        }
    }

    public JWTPayloadDto getPayloadFromJWT(String token) throws IllegalAccessException {
        DecodedJWT decodedJWT = JWT.decode(token);
        // get field
        List<Field> fields = Arrays.stream(JWTPayloadDto.class.getDeclaredFields())
                .filter(field -> !field.getName().startsWith("$")).collect(Collectors.toList());
        fields.forEach(field -> field.setAccessible(true));
        // set field
        JWTPayloadDto jwtPayloadDto = new JWTPayloadDto();
        for (Field field : fields) {
            Claim claim = decodedJWT.getClaim(field.getName());
            if(claim != null) {
                field.set(jwtPayloadDto, claim.asString());
            }
        }
        return jwtPayloadDto;
    }
}
