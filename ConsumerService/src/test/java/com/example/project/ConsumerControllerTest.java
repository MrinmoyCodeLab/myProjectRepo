package com.example.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerControllerTest {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	 
	@SuppressWarnings("deprecation")
	@Test
	public void testGetMessage() {
	        String message = restTemplate.getForObject("http://ApplicationService/hello" , String.class);

	        Assert.assertEquals("hello world", message);
	    }
	
	
}
