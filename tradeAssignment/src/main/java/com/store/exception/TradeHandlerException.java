package com.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.store.common.constant.CommonConstant;
import com.store.common.error.ErrorResponse;

@RestControllerAdvice
public class TradeHandlerException {

	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<ErrorResponse> handlerException(RuntimeException exception) {
		
		String code ="";
		String message ="";
		if(exception instanceof TradeServiceException) {
			TradeServiceException tradeServiceException = (TradeServiceException) exception;
			code = tradeServiceException.getErrorCode();
			message = tradeServiceException.getMessage();
		}
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(code);
		errorResponse.setMessage(message);
		if(CommonConstant.TRADE_NOT_ACCEPTABLE.equalsIgnoreCase(code)) {
			return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
