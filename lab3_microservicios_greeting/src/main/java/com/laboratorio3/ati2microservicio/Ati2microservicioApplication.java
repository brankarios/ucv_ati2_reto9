package com.laboratorio3.ati2microservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Ati2microservicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ati2microservicioApplication.class, args);
	}

}
