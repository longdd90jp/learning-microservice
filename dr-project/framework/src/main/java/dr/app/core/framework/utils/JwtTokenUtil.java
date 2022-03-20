package dr.app.core.framework.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import dr.app.core.framework.constant.ErrorCode;
import dr.app.core.framework.constant.JwtAlgorithm;
import dr.app.core.framework.dto.GeneratedTokenDto;
import dr.app.core.framework.dto.JWTPayloadDto;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
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
    private long accessTokenExpireInSecond;
    private long refreshTokenExpireInSecond;

    public JwtTokenUtil(String secret, JwtAlgorithm algorithmName, String issuer,
                        long accessTokenExpireInSecond, long refreshTokenExpireInSecond) {
        this.issuer = issuer;
        this.accessTokenExpireInSecond = accessTokenExpireInSecond;
        this.refreshTokenExpireInSecond = refreshTokenExpireInSecond;
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
            default:
                this.algorithm = Algorithm.HMAC512(this.secret);
                break;
        }
    }

    public GeneratedTokenDto generateAccessToken(JWTPayloadDto payloadDto, long targetTime) {
        GeneratedTokenDto tokenDto = new GeneratedTokenDto();
        long expireTime = targetTime + (accessTokenExpireInSecond * 1000);
        tokenDto.setExpireTime(expireTime);
        Date expireDate = new Date(expireTime);

        String generatedToken = JWT.create()
                .withIssuer(issuer)
                .withClaim("userId", payloadDto.getUserId())
                .withClaim("officeId", payloadDto.getOfficeId())
                .withClaim("officeUserId", payloadDto.getOfficeUserId())
                .withClaim("officeType", payloadDto.getOfficeType())
                .withExpiresAt(expireDate)
                .sign(algorithm);
        tokenDto.setGeneratedToken(generatedToken);
        return tokenDto;
    }

    public GeneratedTokenDto generateRefreshToken(long targetTime) {
        GeneratedTokenDto tokenDto = new GeneratedTokenDto();
        long expireTime = targetTime + (refreshTokenExpireInSecond * 1000);
        tokenDto.setExpireTime(expireTime);
        Date expireDate = new Date(expireTime);

        String refreshToken = JWT.create()
                .withIssuer(issuer)
                .withExpiresAt(expireDate)
                .sign(algorithm);
        tokenDto.setGeneratedToken(refreshToken);
        return tokenDto;
    }

    /**
     * verify access token
     * @param token verify token value
     * @return blank if token valid, ERR_TOKEN_001 if token expired, ERR_TOKEN_002 for other invalid token
     */
    public String verifyJWTAccessToken(String token) {
        return verifyToken(token, accessTokenExpireInSecond);
    }

    /**
     * verify refresh token
     * @param token verify token value
     * @return blank if token valid, ERR_TOKEN_001 if token expired, ERR_TOKEN_002 for other invalid token
     */
    public String verifyJWTRefreshToken(String token) {
        return verifyToken(token, refreshTokenExpireInSecond);
    }

    private String verifyToken(String token, long expireInSecond) {
        String errorCode = StringUtils.EMPTY;
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .acceptExpiresAt(expireInSecond)
                    .build();
            verifier.verify(token);
        } catch (TokenExpiredException ex) {
            errorCode = ErrorCode.ERR_TOKEN_001;
        } catch (JWTVerificationException ex) {
            errorCode = ErrorCode.ERR_TOKEN_002;
        }
        return errorCode;
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
