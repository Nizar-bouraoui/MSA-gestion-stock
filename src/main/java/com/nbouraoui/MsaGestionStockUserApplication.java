package com.nbouraoui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsaGestionStockUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaGestionStockUserApplication.class, args);
	}

}
