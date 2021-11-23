package com.springtest.junitExample.util;

import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

public class AppUtil {
	
	
	public static String sanitizeInput(String input) {
		
		if(StringUtils.hasLength(input)) {
			return HtmlUtils.htmlEscape(input);
		}
		return input;
	}
	
	
}
