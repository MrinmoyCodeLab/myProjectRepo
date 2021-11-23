package com.springboot.SpringCacheExmple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheExmpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheExmpleApplication.class, args);
	}

}
