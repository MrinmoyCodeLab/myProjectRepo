package com.store.service;


import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.store.common.constant.CommonConstant;
import com.store.common.util.CommonUtil;
import com.store.dao.TradeServiceRepository;
import com.store.exception.TradeServiceException;
import com.store.helper.TradeAdvHelper;
import com.store.model.OrderTradeRequest;
import com.store.model.OrderTradeResponse;
import com.store.model.TradeDetailVo;

@Service
public class TradeAdvService {
	
	@Autowired
	public TradeServiceRepository tradeServiceRepository; 
	@Autowired
	public TradeAdvHelper tradeAdvHelper ;
	
	public OrderTradeResponse saveTradeDetails(OrderTradeRequest orderTradeRequest) {
		
		OrderTradeResponse response = new OrderTradeResponse();
		try {
			System.out.println("saveTradeDetails Service started .......!!!!!");
			if(CommonUtil.assertNotNullObject(orderTradeRequest)) {
				
				LocalDateTime maturityDate = CommonUtil.getDateFromString(orderTradeRequest.getMaturityDate());
				if(maturityDate!= null && maturityDate.isBefore(CommonUtil.getCurrentSystemDate())) {
					throw new TradeServiceException(CommonConstant.TRADE_NOT_ACCEPTABLE, CommonConstant.MATURITY_DATE_ERROR , TradeAdvService.class );
				}				
				int count = tradeServiceRepository.findUpperVersionByTradeId(orderTradeRequest.getTradeId(),orderTradeRequest.getVersion());
				if(count > 0) {
					throw new TradeServiceException(CommonConstant.TRADE_NOT_ACCEPTABLE, CommonConstant.MATURITY_DATE_ERROR , TradeAdvService.class );
				}
				
				TradeDetailVo tradeDetailVo = tradeServiceRepository.findTradeByVersion(orderTradeRequest.getTradeId(),orderTradeRequest.getVersion());
				if(CommonUtil.assertNotNullObject(tradeDetailVo)) {
					return tradeAdvHelper.saveTradeDetailsinRepo(tradeDetailVo, orderTradeRequest, false);	
				}
				return tradeAdvHelper.saveTradeDetailsinRepo(new TradeDetailVo(), orderTradeRequest , true);								
			}
			System.out.println("saveTradeDetails Service End .......!!!!!");
		}
		catch (TradeServiceException e) {
			e.printStackTrace();
			throw new TradeServiceException(e.getErrorCode(),e.getMessage() , TradeAdvService.class );
		}catch (Exception e) {
			e.printStackTrace();
			throw new TradeServiceException("500",e.getMessage() , TradeAdvService.class );
		}
		return response;
		
	}
	

	@Scheduled(cron = "0 10 10 10 * ?")
	public void validateTradeExpiryInStore() throws Exception {
		
		try {
			System.out.println("validateTradeExpiryInStore started .......!!!!!");
			tradeServiceRepository.updateAllByExpired("N");
			System.out.println("validateTradeExpiryInStore Ended .......!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("validateTradeExpiryInStore Exception .......!!!!!");
			throw new Exception(e.getMessage());
		}
		
	}
	
}
