package com.mathtrainer.backed.gamification.client;

import com.mathtrainer.backed.gamification.client.dto.MultiplicationResultAttempt;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * This implementation of MultiplicationResultAttemptClient interface connects to
 * the Multiplication microservice via REST.
 */
@Component
@Slf4j
class MultiplicationResultAttemptClientImpl implements MultiplicationResultAttemptClient {

    private final RestTemplate restTemplate;
    private final String multiplicationHost;
    private final LoadBalancerClient loadBalancer;

    @Autowired
    public MultiplicationResultAttemptClientImpl(
            final RestTemplate restTemplate,
            @Value("${multiplicationHost}") final String multiplicationHost,
            final LoadBalancerClient loadBalancer
    ) {
        this.restTemplate = restTemplate;
        this.multiplicationHost = multiplicationHost;
        this.loadBalancer = loadBalancer;
    }

    @HystrixCommand(fallbackMethod = "defaultResult")
    @Override
    public MultiplicationResultAttempt retrieveMultiplicationResultAttemptbyId(final String multiplicationResultAttemptId) {
        String baseUri = loadBalancer.choose(multiplicationHost).getUri().toString();
        log.info(String.format("***** service: %s; loadbalancer uri: %s", multiplicationHost, baseUri));
        return restTemplate.getForObject(
                baseUri + "/results/" + multiplicationResultAttemptId,
                MultiplicationResultAttempt.class);
    }

    private MultiplicationResultAttempt defaultResult(final Long multiplicationResultAttemptId) {
        return new MultiplicationResultAttempt("fakeAlias",
                10, 10, 100, true);
    }
}

