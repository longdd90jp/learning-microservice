package learing.ec.backend.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(OrderApplication.class, args);
    }
}
