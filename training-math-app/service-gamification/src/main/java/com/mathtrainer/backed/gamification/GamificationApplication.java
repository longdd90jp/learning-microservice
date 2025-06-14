package com.mathtrainer.backed.gamification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GamificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamificationApplication.class, args);
	}
}
