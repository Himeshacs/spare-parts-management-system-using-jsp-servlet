package com.shop.model;

public class Purchase {

	//Default Constructor
	public Purchase() {
		
	}
	
	//Attributes of Purchase Class
	private String purchaseID;
	private String supplierID;
	private String productID;
	private String unitPrice;
	private String totalQuantity;
	private String subTotal;
	private String purchaseStatus;
	private String purchaseDate;
	
	//Setters and Getters for Purchase ID
	public String getPurchaseID() {
		return purchaseID;
	}
	
	public void setPurchaseID(String purchaseID) {
		this.purchaseID = purchaseID;
	}
	
	//Setters and Getters for Supplier ID
	public String getSupplierID() {
		return supplierID;
	}
	
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	
	//Setters and Getters for Product ID
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	//Setters and Getters for Unit Price
	public String getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	//Setters and Getters for Total Quantity
	public String getTotalQuantity() {
		return totalQuantity;
	}
	
	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
	//Setters and Getters for Sub Total
	public String getSubTotal() {
		return subTotal;
	}
	
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	
	//Setters and Getters for Purchase Status
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	
	//Setters and Getters for Purchase Date
	public String getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	//toString to return desired output
	@Override
	public String toString() {
		return "Purchase [purchaseID=" + purchaseID + ", supplierID=" + supplierID + ", productID=" + productID
				+ ", unitPrice=" + unitPrice + ", totalQuantity=" + totalQuantity + ", subTotal=" + subTotal
				+ ", purchaseStatus=" + purchaseStatus + ", purchaseDate=" + purchaseDate + "]";
	}

	
		
}

