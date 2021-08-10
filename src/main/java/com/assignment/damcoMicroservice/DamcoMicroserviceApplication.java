package com.assignment.damcoMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author Kunal
 * Entry class for Spring Boot Application
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DamcoMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DamcoMicroserviceApplication.class, args);
	}

}
