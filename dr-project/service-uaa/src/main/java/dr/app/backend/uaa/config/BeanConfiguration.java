package dr.app.backend.uaa.config;

import dr.app.core.framework.constant.JwtAlgorithm;
import dr.app.core.framework.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.algorithm-name}")
    private JwtAlgorithm algorithmName;

    @Value("${jwt.access-token-expire-in-second}")
    private long accessTokenExpireInSecond;

    @Value("${jwt.refresh-token-expire-in-second}")
    private long refreshTokenExpireInSecond;

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil(secret, algorithmName, issuer, accessTokenExpireInSecond, refreshTokenExpireInSecond);
        return jwtTokenUtil;
    }
}
