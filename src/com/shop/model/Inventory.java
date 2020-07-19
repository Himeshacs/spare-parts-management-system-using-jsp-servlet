package com.shop.model;

public class Inventory {

	//Default Constructor
	public Inventory() {
		
	}
	
	//Attributes of Inventory Class
	private String inventoryID;
	private String productID;
	private String instoreInventory;
	private String unitsPurchased;
	private String unitsSold;
	private String closingInventory;
	private String updateDate;
	private String updateTime;
	
	
	//Setters and Getters for Inventory ID
	public String getInventoryID() {
		return inventoryID;
	}
	
	public void setInventoryID(String inventoryID) {
		this.inventoryID = inventoryID;
	}
	
	//Setters and Getters for Product ID
	public String getProductID() {
		return productID;
	}
	
	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	//Setters and Getters for Instore Inventory
	public String getInstoreInventory() {
		return instoreInventory;
	}
	
	public void setInstoreInventory(String instoreInventory) {
		this.instoreInventory = instoreInventory;
	}
	
	//Setters and Getters for Units Purchased
	public String getUnitsPurchased() {
		return unitsPurchased;
	}
	
	public void setUnitsPurchased(String unitsPurchased) {
		this.unitsPurchased = unitsPurchased;
	}
	
	//Setters and Getters for Units Sold
	public String getUnitsSold() {
		return unitsSold;
	}
	
	public void setUnitsSold(String unitsSold) {
		this.unitsSold = unitsSold;
	}
	
	//Setters and Getters for Closing Inventory
	public String getClosingInventory() {
		return closingInventory;
	}
	
	public void setClosingInventory(String closingInventory) {
		this.closingInventory = closingInventory;
	}
	
	//Setters and Getters for Update Date
	public String getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	//Setters and Getters for Update Time
	public String getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
	//toString to return desired output
	@Override
	public String toString() {
		return "Inventory [inventoryID=" + inventoryID + ", productID=" + productID + ", instoreInventory="
				+ instoreInventory + ", unitsPurchased=" + unitsPurchased + ", unitsSold=" + unitsSold
				+ ", closingInventory=" + closingInventory + ", updateDate=" + updateDate + ", updateTime=" + updateTime
				+ "]";
	}
	
	
}
