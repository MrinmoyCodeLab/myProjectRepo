package com.store.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class TradeDetailVo {
	
	private String tradeId;
	private int version;
	private String counterPartyId;
	private String bookId;
	private Timestamp maturityDate;
	private Timestamp createdDate;
	private String expired;
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCounterPartyId() {
		return counterPartyId;
	}
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Timestamp getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Timestamp maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	
	
	

}
