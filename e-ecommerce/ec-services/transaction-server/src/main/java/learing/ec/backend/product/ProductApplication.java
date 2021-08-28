package learing.ec.backend.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProductApplication.class, args);
    }
}
