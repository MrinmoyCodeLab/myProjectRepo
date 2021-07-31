package com.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages= {"com.store"})
public class TradeAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeAssignmentApplication.class, args);
	}

	
}
