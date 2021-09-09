package com.citi.emea.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.emea.config.JsonDataPropertyConfig;
import com.citi.emea.util.JsonDataUtility;

@Service
public class JsonDataServiceImpl {

	@Autowired
	public JsonDataPropertyConfig propertyConfig;
	
	@Autowired
	public JsonDataUtility jsonDataUtility;
	
	public JSONObject getJsonSample(String country, String fileName) {
		
		JSONObject jsonFile = new JSONObject();
		boolean isvalidCountry = false;
		try {			
			String[] countryList = propertyConfig.getCountry().split(",");
			if(null != countryList && countryList.length > 0) {
				for(String proCountry : countryList) {
					if(country.equalsIgnoreCase(proCountry)) {
						isvalidCountry = true;
						break;
					}
				}
			}
			if(isvalidCountry) {
				jsonFile = jsonDataUtility.getJsonFile(country, propertyConfig.getFilePathName(), fileName);
			}else {
				jsonFile.put("Error", "Invalid country code . Please verify country entry in property file");
			}
		}catch(Exception e) {
			e.printStackTrace();
			jsonFile.put("Error", "Invalid country code . Please verify country entry in property file");
		}
		
		return jsonFile;
		
	}
	
}
