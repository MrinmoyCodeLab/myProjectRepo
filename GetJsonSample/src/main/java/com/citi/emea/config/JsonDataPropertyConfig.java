package com.citi.emea.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("classpath:jsonDataConfig.properties")
public class JsonDataPropertyConfig {
	
	@Value("${countryList}")
	String countryList;
	
	@Value("${filePathName}")
	String filePathName;

	public String getCountry() {
		return countryList;
	}

	public void setCountry(String countryList) {
		this.countryList = countryList;
	}

	public String getFilePathName() {
		return filePathName;
	}

	public void setFilePathName(String filePathName) {
		this.filePathName = filePathName;
	}
	
	
}
