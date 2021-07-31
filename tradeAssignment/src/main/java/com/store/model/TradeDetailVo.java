package com.store.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class TradeDetailVo {
	
	@Id
	@GeneratedValue
	@Column(name = "trade_txn_id")
	private Long tradeTxnID;
	@Column
	private String tradeId;
	@Column
	private Long version;
	@Column
	private String counterPartyId;
	@Column
	private String bookId;
	@Column
	private Timestamp maturityDate;
	@Column
	private Timestamp createdDate;
	@Column
	private String expired;
	
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
