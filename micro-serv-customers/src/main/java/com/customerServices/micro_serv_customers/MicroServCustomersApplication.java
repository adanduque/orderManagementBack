package com.customerServices.micro_serv_customers;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.Duration;


@EnableDiscoveryClient
@EnableCaching
@SpringBootApplication
public class MicroServCustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServCustomersApplication.class, args);
	}
	//Resilience
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {

		return factory -> factory.configureDefault(
				id -> new Resilience4JConfigBuilder(id)
						.timeLimiterConfig(TimeLimiterConfig.ofDefaults())
						.circuitBreakerConfig(CircuitBreakerConfig.custom().slidingWindowSize(10)
								.permittedNumberOfCallsInHalfOpenState(5)
								.failureRateThreshold(50)
								.waitDurationInOpenState(Duration.ofSeconds(10)).build())
						.build());
	}
}
