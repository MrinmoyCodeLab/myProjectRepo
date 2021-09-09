package com.example.flywaydb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.flywaydb.repository.InventoryRepository;
import com.example.flywaydb.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryControllerTest {

	
	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void addProduct_Ok() throws Exception{
		Inventory i= new Inventory();
		i.setProduct_Id(1);
		i.setProduct_Name("maaza");
		i.setProduct_Category("beverages");
		i.setFare(25.00);
		byte[] iJson = toJson(i);
		i.setProduct_Id(2);
		i.setProduct_Name("cornetto");
		i.setProduct_Category("ice creams");
		i.setFare(50.00);
		byte[] iJson2 = toJson(i);
		mockMvc.perform(post("/create")
				.content(iJson)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
		mockMvc.perform(post("/create")
				.content(iJson2)
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

	}
	@Test
	public void retrieve_Ok() throws Exception{
		addProduct_Ok();
		mockMvc.perform(get("/1" )).andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.product_Id").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.product_Name").value("maaza"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.product_Category").value("beverages"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.fare").value(25.00));
	}
	@Test
	public void deleteProduct_Ok() throws Exception{
		mockMvc.perform(delete("/delete/1" )).andDo(print())
        .andExpect(status().isOk());
	}
	

	
	private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }
   
}
