package dr.app.backend.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    public static final String HEALTH = "/health";
    private static final String[] SWAGGER_PATTERNS = {"/swagger-ui.html", "/webjars/**"};
}