package learing.ec.backend.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PaymentApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PaymentApplication.class, args);
    }
}
