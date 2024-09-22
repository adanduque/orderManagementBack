package com.eurekaServer.micro_serv_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroServEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServEurekaApplication.class, args);
	}

}
