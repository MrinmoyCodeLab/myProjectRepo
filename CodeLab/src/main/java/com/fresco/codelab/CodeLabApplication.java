package com.fresco.codelab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fresco.codelab")
public class CodeLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeLabApplication.class, args);
	}

}
