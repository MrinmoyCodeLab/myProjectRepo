package com.citi.emea.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citi.emea.service.JsonDataServiceImpl;

@RestController
public class JsonDataController {

	@Autowired
	public JsonDataServiceImpl jsonDataImpl;
	
	@RequestMapping(value = "/getJsonData/{country}/{fileName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public JSONObject getCountrySpecificJsonData(@PathVariable String country,@PathVariable String fileName) {		
		JSONObject jsonSample = jsonDataImpl.getJsonSample(country, fileName);
		return jsonSample;
	}
	
}
