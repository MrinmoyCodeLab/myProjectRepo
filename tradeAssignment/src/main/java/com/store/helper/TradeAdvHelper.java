package com.store.helper;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.common.util.CommonUtil;
import com.store.dao.TradeServiceRepository;
import com.store.exception.TradeServiceException;
import com.store.model.OrderTradeRequest;
import com.store.model.OrderTradeResponse;
import com.store.model.TradeDetailVo;

@Service
public class TradeAdvHelper {
	
	@Autowired
	public TradeServiceRepository tradeServiceRepository; 
	
	public OrderTradeResponse saveTradeDetailsinRepo(TradeDetailVo tradeDetailsVo, OrderTradeRequest orderTradeReq , boolean isNewEntry) {
		
		OrderTradeResponse response = new OrderTradeResponse();
		TradeDetailVo tradeDetailVo = null;
		try {
			
			if(isNewEntry) {
				tradeDetailsVo.setTradeId(orderTradeReq.getTradeId());
				tradeDetailsVo.setVersion(orderTradeReq.getVersion());
				tradeDetailsVo.setCounterPartyId(orderTradeReq.getCounterPartyId());
				tradeDetailsVo.setBookId(orderTradeReq.getBookId());
				tradeDetailsVo.setMaturityDate(Timestamp.valueOf(CommonUtil.getDateFromString(orderTradeReq.getMaturityDate())));
				tradeDetailsVo.setCreatedDate(Timestamp.valueOf(CommonUtil.getCurrentSystemDate()));
				tradeDetailsVo.setExpired("N");				
				tradeDetailVo = tradeServiceRepository.save(tradeDetailsVo);
				
			}else {
				tradeDetailsVo.setVersion(orderTradeReq.getVersion());
				tradeDetailsVo.setCounterPartyId(orderTradeReq.getCounterPartyId());
				tradeDetailsVo.setBookId(orderTradeReq.getBookId());
				tradeDetailsVo.setMaturityDate(Timestamp.valueOf(CommonUtil.getDateFromString(orderTradeReq.getMaturityDate())));
				tradeDetailsVo.setCreatedDate(Timestamp.valueOf(CommonUtil.getCurrentSystemDate()));
				tradeDetailsVo.setExpired("N");	
				tradeDetailVo = tradeServiceRepository.save(tradeDetailsVo);
				
			}		
			if(CommonUtil.assertNotNullObject(tradeDetailVo)) {
				response.setTradeId(tradeDetailVo.getTradeId());
				response.setVersion(tradeDetailVo.getVersion());
				response.setCreatedDate(tradeDetailVo.getCreatedDate().toString());
				return response;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new TradeServiceException("500",e.getMessage() , TradeAdvHelper.class );
		}		
		return response;
		
	}

}
