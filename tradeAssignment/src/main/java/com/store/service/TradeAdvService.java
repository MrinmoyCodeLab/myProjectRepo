package com.store.service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.common.constant.CommonConstant;
import com.store.common.util.CommonUtil;
import com.store.dao.TradeServiceRepository;
import com.store.exception.TradeServiceException;
import com.store.model.OrderTradeRequest;
import com.store.model.OrderTradeResponse;
import com.store.model.TradeDetailVo;

@Service
public class TradeAdvService {
	
	@Autowired
	public TradeServiceRepository tradeServiceRepository; 
	
	public OrderTradeResponse saveTradeDetails(OrderTradeRequest orderTradeRequest) {
		
		OrderTradeResponse response = new OrderTradeResponse();
		try {
			if(CommonUtil.assertNotNullObject(orderTradeRequest)) {
				
				LocalDateTime maturityDate = CommonUtil.getDateFromString(orderTradeRequest.getMaturityDate());
				if(maturityDate!= null && maturityDate.isBefore(CommonUtil.getCurrentSystemDate())) {
					throw new TradeServiceException(CommonConstant.TRADE_NOT_ACCEPTABLE, CommonConstant.MATURITY_DATE_ERROR , TradeAdvService.class );
				}
				
				List<TradeDetailVo> tradeDetailList = tradeServiceRepository.findAllByTradeId(orderTradeRequest.getTradeId());
				if(CommonUtil.assertNotNullList(tradeDetailList)) {
					Optional<Integer> minVersion=  tradeDetailList.stream().map((TradeDetailVo tradeDetailVo)->{
											return tradeDetailVo.getVersion();
									}
								).min(Integer::compare);
					
					if(orderTradeRequest.getVersion() < minVersion.get()) {
						throw new TradeServiceException(CommonConstant.TRADE_NOT_ACCEPTABLE, CommonConstant.MATURITY_DATE_ERROR , TradeAdvService.class );
					}
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new TradeServiceException("500",e.getMessage() , TradeAdvService.class );
		}
		return response;
		
	}
	

}
