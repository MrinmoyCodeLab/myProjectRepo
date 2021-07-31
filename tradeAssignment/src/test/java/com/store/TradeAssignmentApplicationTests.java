package com.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.store.model.OrderTradeRequest;
import com.store.util.JsonUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TradeAssignmentApplicationTests {

	@Autowired
	private MockMvc mvc; 
	
	
	@Test
	public void test1_saveTradeDetails() throws Exception {		
		OrderTradeRequest ordTrdReq =  new OrderTradeRequest(); 		
		ordTrdReq.setTradeId("T1");
		ordTrdReq.setVersion(1l);
		ordTrdReq.setCounterPartyId("CP-1");
		ordTrdReq.setBookId("B1");
		ordTrdReq.setMaturityDate("30/12/2021");		
		MvcResult mvcResult  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq)))
				.andReturn();		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	
	}
	
	@Test
	public void test2_maturityDateCompareToCurrentDate() throws Exception {		
		OrderTradeRequest ordTrdReq =  new OrderTradeRequest(); 		
		ordTrdReq.setTradeId("T1");
		ordTrdReq.setVersion(1l);
		ordTrdReq.setCounterPartyId("CP-1");
		ordTrdReq.setBookId("B1");
		ordTrdReq.setMaturityDate("30/6/2021");		
		MvcResult mvcResult  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq)))
				.andReturn();		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
	
	}

	
	@Test
	public void test2_compareLowerVersionTrade() throws Exception {		
		OrderTradeRequest ordTrdReq =  new OrderTradeRequest(); 		
		ordTrdReq.setTradeId("T1");
		ordTrdReq.setVersion(1l);
		ordTrdReq.setCounterPartyId("CP-1");
		ordTrdReq.setBookId("B1");
		ordTrdReq.setMaturityDate("30/6/2021");		
		MvcResult mvcResult  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq)))
				.andReturn();		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
	
	}
	
}
