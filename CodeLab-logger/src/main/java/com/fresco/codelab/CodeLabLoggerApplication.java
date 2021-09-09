package com.fresco.codelab;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration

public class CodeLabLoggerApplication {
	
	static final Logger debugLog = Logger.getLogger("debugLogger");
	static final Logger resultLog = Logger.getLogger("reportsLogger");
	public static void main(String[] args) {
		debugLog.info("Main Start ");
		resultLog.info("Main Start ");
		SpringApplication.run(CodeLabLoggerApplication.class, args);
		debugLog.info("Main End ");
		resultLog.info("Main End ");
	}
	

}
