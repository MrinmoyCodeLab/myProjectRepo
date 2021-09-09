package com.example.RibbonProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping
public class HelloController {


	@RequestMapping("/hello")
	public String getHello() {
		return "hello world";
		
	}
	
}
