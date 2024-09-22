package com.customerServices.micro_serv_customers.controller;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Hidden
public class CircuitBreakerStatusController {

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @GetMapping("/circuitbreaker/status")
    public String getCircuitBreakerStatus() {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("customerServiceCircuitBreaker");
        return circuitBreaker.getState().name();
    }
}
