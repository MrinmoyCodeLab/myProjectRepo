package com.store.model;

public class OrderTradeResponse {
	
	private String tradeId;
	private Long version;
	private String createdDate;
	
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
