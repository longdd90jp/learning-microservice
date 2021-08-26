package learing.ec.backend.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AuthApplication.class, args);
    }
}
