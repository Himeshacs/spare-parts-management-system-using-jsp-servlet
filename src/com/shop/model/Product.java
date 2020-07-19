package com.shop.model;

public class Product {

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	private String productId;
	private String productName;
	private String description;
	private String grade;
	private String type;
	private String brand;
	private String modal;
	private double price;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	private String imagePath;


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", grade=" + grade + ", type="
				+ type + ", brand=" + brand + ", modal=" + modal + ", imagePath=" + imagePath + "]";
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModal() {
		return modal;
	}

	public void setModal(String modal) {
		this.modal = modal;
	}


}
