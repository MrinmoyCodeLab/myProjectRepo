package com.citi.emea.jsonSample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.citi.emea.config.JsonDataPropertyConfig;

@SpringBootApplication
@ComponentScan("com.citi.emea")
public class GetJsonSampleApplication implements CommandLineRunner {
	
	@Autowired
	JsonDataPropertyConfig propertyConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(GetJsonSampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Appication will run for the following countries : " + propertyConfig.getCountry() 
		+ " .  Please make sure to send proper country code .  ");
		
		System.out.println("Please add country code in property files if you want to for other countries. ");
		
		System.out.println("Please make sure to put json file in the following path :  " + propertyConfig.getFilePathName());
	}

}
