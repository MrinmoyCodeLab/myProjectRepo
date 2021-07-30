package com.store.exception;

public class TradeServiceException extends RuntimeException{
	
	private String errorCode;
	private Class<?> sourceClass;
	private StackTraceElement[] elements;
	
	public TradeServiceException(String code, String message, Class<?> sourceClass ) {
		super(message);
		this.errorCode= code;
		this.sourceClass = sourceClass;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public StackTraceElement[] getElements() {
		return elements;
	}
	public void setElements(StackTraceElement[] elements) {
		this.elements = elements;
	}
	
	

}
