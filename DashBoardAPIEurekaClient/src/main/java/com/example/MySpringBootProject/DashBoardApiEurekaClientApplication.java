package com.example.MySpringBootProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DashBoardApiEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashBoardApiEurekaClientApplication.class, args);
	}

}
