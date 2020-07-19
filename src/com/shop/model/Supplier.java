package com.shop.model;

public class Supplier {

	//Default Constructor
		public Supplier() {
			
		}
		
		//Attributes of Supplier Class
		private String supplierID;
		private String companyName;
		private String contactPerson;
		private String email;
		private String contactNumber;
		private String companyAddress;
		
		//Setters and Getters for Supplier ID
		public String getSupplierID() {
			return supplierID;
		}
		
		public void setSupplierID(String supplierID) {
			this.supplierID = supplierID;
		}
		
		//Setters and Getters for Company Name
		public String getCompanyName() {
			return companyName;
		}
		
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		
		//Setters and Getters for Contact Person
		public String getContactPerson() {
			return contactPerson;
		}
		
		public void setContactPerson(String contactPerson) {
			this.contactPerson = contactPerson;
		}
		
		//Setters and Getters for Email
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		//Setters and Getters for Contact Number
		public String getContactNumber() {
			return contactNumber;
		}
		
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		
		//Setters and Getters for Company Address
		public String getCompanyAddress() {
			return companyAddress;
		}
		
		public void setCompanyAddress(String companyAddress) {
			this.companyAddress = companyAddress;
		}
		
		//toString to return desired output
		@Override
		public String toString() {
			return "Supplier [supplierID=" + supplierID + ", companyName=" + companyName + ", contactPerson="
					+ contactPerson + ", email=" + email + ", contactNumber=" + contactNumber + ", companyAddress="
					+ companyAddress + "]";
		}
		
}
