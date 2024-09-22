package com.orderServices.micro_serv_oders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroServOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServOrdersApplication.class, args);
	}

}
