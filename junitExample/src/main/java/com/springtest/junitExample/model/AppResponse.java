package com.springtest.junitExample.model;

public class AppResponse<T> {
	
	public enum Status{
		success,
		error,
		failed;
	}
	
	private String message;
	private T data;
	
	private Status status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
