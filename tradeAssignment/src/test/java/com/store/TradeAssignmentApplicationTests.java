package com.store;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

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

import com.store.common.util.CommonUtil;
import com.store.dao.TradeServiceRepository;
import com.store.model.OrderTradeRequest;
import com.store.model.TradeDetailVo;
import com.store.service.TradeAdvService;
import com.store.util.JsonUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TradeAssignmentApplicationTests {

	@Autowired
	private MockMvc mvc; 
	
	
	@Autowired
	public TradeServiceRepository tradeServiceRepository; 
	
	
	@Autowired
	public TradeAdvService tradeAdvService;
	
	
	@Test
	public void test1_saveTradeDetails() throws Exception {		
		OrderTradeRequest ordTrdReq1 =  new OrderTradeRequest(); 		
		ordTrdReq1.setTradeId("T1");
		ordTrdReq1.setVersion(1);
		ordTrdReq1.setCounterPartyId("CP-1");
		ordTrdReq1.setBookId("B1");
		ordTrdReq1.setMaturityDate("30/10/2021");		
		MvcResult mvcResult  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq1)))
				.andReturn();		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		OrderTradeRequest ordTrdReq2 =  new OrderTradeRequest(); 		
		ordTrdReq2.setTradeId("T2");
		ordTrdReq2.setVersion(1);
		ordTrdReq2.setCounterPartyId("CP-1");
		ordTrdReq2.setBookId("B1");
		ordTrdReq2.setMaturityDate("30/11/2021");
		
		MvcResult mvcResult2  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq2)))
				.andReturn();		
		int secondRecordStatus = mvcResult2.getResponse().getStatus();
		assertEquals(200, secondRecordStatus);
		

		OrderTradeRequest ordTrdReq3 =  new OrderTradeRequest(); 		
		ordTrdReq3.setTradeId("T2");
		ordTrdReq3.setVersion(2);
		ordTrdReq3.setCounterPartyId("CP-2");
		ordTrdReq3.setBookId("B1");
		ordTrdReq3.setMaturityDate("30/12/2021");
		
		MvcResult mvcResult3  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq3)))
				.andReturn();		
		int thirdRecordStatus = mvcResult3.getResponse().getStatus();
		assertEquals(200, thirdRecordStatus);
		

		OrderTradeRequest ordTrdReq4 =  new OrderTradeRequest(); 		
		ordTrdReq4.setTradeId("T3");
		ordTrdReq4.setVersion(3);
		ordTrdReq4.setCounterPartyId("CP-3");
		ordTrdReq4.setBookId("B2");
		ordTrdReq4.setMaturityDate("30/12/2021");
		
		MvcResult mvcResult4  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq4)))
				.andReturn();		
		int forthRecordStatus = mvcResult4.getResponse().getStatus();
		assertEquals(200, forthRecordStatus);
	}
	
	@Test
	public void test2_maturityDateCompareToCurrentDate() throws Exception {		
		
		OrderTradeRequest ordTrdReq =  new OrderTradeRequest(); 		
		ordTrdReq.setTradeId("T4");
		ordTrdReq.setVersion(1);
		ordTrdReq.setCounterPartyId("CP-4");
		ordTrdReq.setBookId("B3");
		ordTrdReq.setMaturityDate("30/06/2021");		
		MvcResult mvcResult  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq)))
				.andReturn();		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(406, status);
	
	}

	
	@Test
	public void test3_compareLowerVersionTradeErrorCase() throws Exception {		
		
		OrderTradeRequest ordTrdReq =  new OrderTradeRequest(); 		
		ordTrdReq.setTradeId("T4");
		ordTrdReq.setVersion(3);
		ordTrdReq.setCounterPartyId("CP-4");
		ordTrdReq.setBookId("B4");
		ordTrdReq.setMaturityDate("30/12/2021");		
		MvcResult mvcResult  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq)))
				.andReturn();		
		int status = mvcResult.getResponse().getStatus();		
		assertEquals(200, status);
		OrderTradeRequest ordTrdReq2 =  new OrderTradeRequest(); 		
		ordTrdReq2.setTradeId("T4");
		ordTrdReq2.setVersion(1);
		ordTrdReq2.setCounterPartyId("CP-4");
		ordTrdReq2.setBookId("B4");
		ordTrdReq2.setMaturityDate("30/12/2021");		
		MvcResult mvcResult2  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq2)))
				.andReturn();		
		int status2 = mvcResult2.getResponse().getStatus();		
		assertEquals(406, status2);
	
	}
	
	@Test
	public void test4_updatedExistingTrade() throws Exception {		
		
		OrderTradeRequest ordTrdReq =  new OrderTradeRequest(); 		
		ordTrdReq.setTradeId("T5");
		ordTrdReq.setVersion(1);
		ordTrdReq.setCounterPartyId("CP-5");
		ordTrdReq.setBookId("B4");
		ordTrdReq.setMaturityDate("30/12/2021");		
		MvcResult mvcResult  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq)))
				.andReturn();		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		OrderTradeRequest ordTrdReq2 =  new OrderTradeRequest(); 		
		ordTrdReq2.setTradeId("T5");
		ordTrdReq2.setVersion(1);
		ordTrdReq2.setCounterPartyId("CP-3");
		ordTrdReq2.setBookId("B3");
		ordTrdReq2.setMaturityDate("30/11/2021");		
		MvcResult mvcResult2  = mvc.perform(post("/orderTradeService")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertStringToJsonString(ordTrdReq2)))
				.andReturn();		
		int status2 = mvcResult2.getResponse().getStatus();
		assertEquals(200, status2);		
		try {			
			
			
			TradeDetailVo tradeDetailVo = tradeServiceRepository.findTradeByVersion(ordTrdReq2.getTradeId(), ordTrdReq2.getVersion());
			
			if(ordTrdReq2.getBookId().equalsIgnoreCase(tradeDetailVo.getBookId()) && ordTrdReq2.getCounterPartyId().equalsIgnoreCase(tradeDetailVo.getCounterPartyId()) ) {
				assertTrue(true);
			}else {
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	
	}
	
	
	@Test
	public void test5_tradeExpiry() throws Exception {		
		
		TradeDetailVo ordTrdReq =  new TradeDetailVo(); 		
		ordTrdReq.setTradeId("T2");
		ordTrdReq.setVersion(1);
		ordTrdReq.setCounterPartyId("CP-3");
		ordTrdReq.setBookId("B3");
		ordTrdReq.setExpired("N");
		ordTrdReq.setMaturityDate(Timestamp.valueOf(CommonUtil.getDateFromString("30/06/2021")));		
		ordTrdReq.setCreatedDate(Timestamp.valueOf(CommonUtil.getCurrentSystemDate()));
		try {
			TradeDetailVo nonExpiredTrade =  tradeServiceRepository.save(ordTrdReq);
			tradeAdvService.validateTradeExpiryInStore();			
			String isExpired = tradeServiceRepository.findExpiredTrade(nonExpiredTrade.getTradeId(), nonExpiredTrade.getVersion(),"Y");
			assertNotNull("Y",isExpired);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
}
