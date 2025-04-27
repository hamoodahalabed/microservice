package com.mohammad.microservies.naming_serve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NamingServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamingServeApplication.class, args);
	}

}
