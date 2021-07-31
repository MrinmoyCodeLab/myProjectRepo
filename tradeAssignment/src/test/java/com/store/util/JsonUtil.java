package com.store.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonUtil {

	
	public static String convertStringToJsonString(Object object) {
		
		ObjectMapper mapper = new ObjectMapper();		
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String responseJson = "";
		
		try {
			responseJson = ow.writeValueAsString(object)	;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return responseJson;
	}
}
