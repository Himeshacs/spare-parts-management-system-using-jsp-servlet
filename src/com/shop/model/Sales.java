package com.shop.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Sales {
	
	private String salesId;
	private String customerId;
	private String productId;
	private int quantity;
	private String date;
	private double total;
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Sales() {
		// TODO Auto-generated constructor stub
	}
	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int i) {
		this.quantity = i;
	}


}
