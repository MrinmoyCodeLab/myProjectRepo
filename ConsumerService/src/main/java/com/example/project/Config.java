package com.example.project;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {	
	
	@Bean
	public RestTemplate geTemplate() {
		return new RestTemplate();
	}
	
 
}