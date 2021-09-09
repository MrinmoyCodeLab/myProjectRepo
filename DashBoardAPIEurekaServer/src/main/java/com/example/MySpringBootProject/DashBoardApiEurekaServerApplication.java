package com.example.MySpringBootProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DashBoardApiEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashBoardApiEurekaServerApplication.class, args);
	}

}
