package com.example.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;


public class Inventory {
	private int product_Id;
	private String product_Name;
	private String product_Category;
	private double fare;
	public int getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getProduct_Category() {
		return product_Category;
	}
	public void setProduct_Category(String product_Category) {
		this.product_Category = product_Category;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	public Inventory(int product_Id, String product_Name, String product_Category, double fare) {
		super();
		this.product_Id = product_Id;
		this.product_Name = product_Name;
		this.product_Category = product_Category;
		this.fare = fare;
		
	}
	public Inventory() {
		// TODO Auto-generated constructor stub
	}
}
