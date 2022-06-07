package com.nbouraoui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaClient
@EnableEurekaServer
@SpringBootApplication
public class MsaGestionStockProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaGestionStockProductApplication.class, args);
	}

}
