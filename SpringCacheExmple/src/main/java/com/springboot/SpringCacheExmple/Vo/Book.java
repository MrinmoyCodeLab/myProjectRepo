package com.springboot.SpringCacheExmple.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Book")
public class Book {

	
	@Id
	@GeneratedValue
	@Column(name="bookId")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String desc;
	@Column(name="authName")
	private String authName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	
	
}
