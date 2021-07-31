package com.store.service;


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
				
				List<TradeDetailVo> tradeDetailList = tradeServiceRepository.findAllByTradeId(orderTradeRequest.getTradeId());
				if(CommonUtil.assertNotNullList(tradeDetailList)) {
					Optional<Long> minVersion=  tradeDetailList.stream().map((TradeDetailVo tradeDetailVo)->{
											return tradeDetailVo.getVersion();
									}
								).min(Long::compare);
					
					if(orderTradeRequest.getVersion() < minVersion.get()) {
						throw new TradeServiceException(CommonConstant.TRADE_NOT_ACCEPTABLE, CommonConstant.MATURITY_DATE_ERROR , TradeAdvService.class );
					}
					for(TradeDetailVo tradeDetailVo : tradeDetailList) {
						if(CommonUtil.assertNotEmptyString(orderTradeRequest.getTradeId()) &&
								orderTradeRequest.getTradeId().equalsIgnoreCase(tradeDetailVo.getTradeId())) {
							return tradeAdvHelper.saveTradeDetailsinRepo(tradeDetailVo, orderTradeRequest, false);
						}
					}
				}				
				return tradeAdvHelper.saveTradeDetailsinRepo(new TradeDetailVo(), orderTradeRequest, true);				
			}
			System.out.println("saveTradeDetails Service End .......!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new TradeServiceException("500",e.getMessage() , TradeAdvService.class );
		}
		return response;
		
	}
	

	@Scheduled(cron = "0 10 10 10 * ?")
	public void validateTradeExpiryInStore() {
		
		List<TradeDetailVo> tradeDetailList = new ArrayList<TradeDetailVo>();
		try {
			System.out.println("validateTradeExpiryInStore started .......!!!!!");
			LocalDateTime currentDate = CommonUtil.getCurrentSystemDate();
			tradeDetailList = tradeServiceRepository.findAllByExpired("N");
			if(CommonUtil.assertNotNullList(tradeDetailList)) {
				for(TradeDetailVo tradeDetailVo : tradeDetailList) {
					if(currentDate.isAfter(tradeDetailVo.getMaturityDate().toLocalDateTime())) {
						tradeDetailVo.setExpired("Y");
						tradeServiceRepository.save(tradeDetailVo);
					}					
				}
			}
			System.out.println("validateTradeExpiryInStore Ended .......!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("validateTradeExpiryInStore Exception .......!!!!!");
		}
		
	}
	
}
