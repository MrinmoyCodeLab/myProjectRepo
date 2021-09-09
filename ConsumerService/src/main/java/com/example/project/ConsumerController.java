package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {

	@Autowired
	public RestTemplate restTemplate;
	
	@RequestMapping("/hello")
	public String getHello() {
		
		String str = restTemplate.getForObject("http://localhost:8888/hello" , String.class);
		return str;
		
	}
	
}
