package dr.app.backend.gateway.config;

import dr.app.core.framework.constant.JwtAlgorithm;
import dr.app.core.framework.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.algorith-name}")
    private JwtAlgorithm algorithmName;

    @Value("${jwt.expire-in-second}")
    private long expireInSecond;

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil(secret, algorithmName, issuer, expireInSecond);
        return jwtTokenUtil;
    }
}
