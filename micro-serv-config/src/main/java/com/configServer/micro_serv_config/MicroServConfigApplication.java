package com.configServer.micro_serv_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MicroServConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServConfigApplication.class, args);
	}

}
