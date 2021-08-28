package learing.ec.backend.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(InventoryApplication.class, args);
    }
}
