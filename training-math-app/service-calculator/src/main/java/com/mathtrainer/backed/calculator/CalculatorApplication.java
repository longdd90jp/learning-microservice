package com.mathtrainer.backed.calculator;

import com.mathtrainer.backed.calculator.utils.SystemUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Collections;
import java.util.Optional;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(CalculatorApplication.class);

        // custom server port by find free port in system variable PORT_RANGE
        Optional<Integer> freePort = SystemUtil.findFreePort();
        if (freePort.isPresent()) {
            app.setDefaultProperties(Collections.singletonMap("server.port", freePort.get()));
            app.run(args);
        } else {
            throw new InterruptedException("All port in system variables [PORT_RANGE] is used, no remain any free port");
        }
    }
}
