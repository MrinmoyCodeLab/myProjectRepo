package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.project")
public class SpringBoot5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot5Application.class, args);
	}
}
