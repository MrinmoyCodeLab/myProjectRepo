package com.example.project;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)		
public class InventoryControllerTest {
	private MockMvc mockMvc;
	 @Autowired
	  WebApplicationContext context;
	 @Before
	  public void setup() throws Exception {
	    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	  }
	 @Test
	 public void getProduct_Ok() throws Exception{
		 RestTemplate rs = new RestTemplate();
		 final String baseUrl = "http://localhost:8000/1";
		 URI uri = new URI(baseUrl);
		 ResponseEntity<Inventory> result = rs.getForEntity(uri, Inventory.class);
		 assertEquals("maaza",result.getBody().getProduct_Name());
	
//		 mockMvc.perform(get("/1" )).andDo(print())
//	        .andExpect(status().isOk())
//	        .andExpect(MockMvcResultMatchers.jsonPath("$.product_Id").value(1))
//	        .andExpect(MockMvcResultMatchers.jsonPath("$.product_Name").value("maaza"))
//	        .andExpect(MockMvcResultMatchers.jsonPath("$.product_Category").value("beverages"))
//	        .andExpect(MockMvcResultMatchers.jsonPath("$.fare").value(25.00));
	 }
}
	 
	 
	 
	 
	 
	 
	 
//	
//	 @Test
//     public void acreateInventory()  throws Exception{
//    	 Inventory i = new Inventory(12,"maaza","beverages",25.00);
//    	 byte[] iJson =toJson(i);
//    	 mockMvc.perform(post("/create").content(iJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
//    	 
//     }
//     private byte[] toJson(Object r) throws Exception {
//    	    ObjectMapper map = new ObjectMapper();
//    	    return map.writeValueAsString(r).getBytes();
//    	  }

