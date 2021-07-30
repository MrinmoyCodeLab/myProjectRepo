package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.store.common.constant.CommonConstant;
import com.store.model.OrderTradeRequest;
import com.store.model.OrderTradeResponse;
import com.store.service.TradeAdvService;

@RestController
public class TradeAdvController {

	@Autowired
	public TradeAdvService tradeAdvService;
	
	@PostMapping(CommonConstant.TRADE_SERVICE_URL)
	public ResponseEntity<Object> saveTradeDetails(@RequestBody OrderTradeRequest request){				
		return new ResponseEntity<Object>((OrderTradeResponse) tradeAdvService.saveTradeDetails(request), HttpStatus.OK);
		
	}
}
