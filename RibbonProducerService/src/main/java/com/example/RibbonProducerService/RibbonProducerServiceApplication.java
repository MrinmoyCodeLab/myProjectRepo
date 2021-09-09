package com.example.RibbonProducerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RibbonProducerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonProducerServiceApplication.class, args);
	}

}
