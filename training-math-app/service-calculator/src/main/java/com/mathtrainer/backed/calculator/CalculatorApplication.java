package com.mathtrainer.backed.calculator;

import com.mathtrainer.backed.common.utils.SystemUtil;
import org.apache.commons.lang3.StringUtils;
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
        modifyDefaultProperties(app);
        app.run(args);
    }

    private static void modifyDefaultProperties(SpringApplication app) throws InterruptedException {
        // custom server port by find free port in system variable PORT_RANGE
        String configPortRange = System.getProperty("port.range");
        if(StringUtils.isEmpty(configPortRange)) {
            throw new InterruptedException("****** system variable port.range is empty ******");
        }
        Optional<Integer> freePort = SystemUtil.findFreePort(configPortRange);
        if (freePort.isPresent()) {
            app.setDefaultProperties(Collections.singletonMap("server.port", freePort.get()));
        } else {
            throw new InterruptedException("All port in system variables [port.range] is used, no remain any free port");
        }
    }
}
