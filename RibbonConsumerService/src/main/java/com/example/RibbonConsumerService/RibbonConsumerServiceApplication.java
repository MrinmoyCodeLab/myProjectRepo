package com.example.RibbonConsumerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "ping-server",configuration = RibbonConfig.class)
public class RibbonConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonConsumerServiceApplication.class, args);
	}

}
