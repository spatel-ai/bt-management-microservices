package com.bt.management.microservices.authenticationservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "horizonService", fallbackMethod = "horizonFallback")
    public String getStatusOfHorizonService() {
        return restTemplate.getForObject(
                "http://HORIZONS-SERVICE/horizons-service/health",
                String.class);
    }

    public String horizonFallback(Throwable ex) {
        System.out.println("---///------------------------------");
        System.out.println(ex);
        return "Horizon service is down. Fallback response.";
    }

}
