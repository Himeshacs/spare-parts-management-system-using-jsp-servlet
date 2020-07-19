package com.shop.dao;

import java.util.ArrayList;

import com.shop.model.Sales;

public interface ISalesDao {

	public Sales getSalesRecord(String salesId);
	public void updateSales(Sales sales);
	public void addSales(Sales sales) ;
	public void deleteSalesRecord(String salesId) ;
	public ArrayList<Sales> getSalesRecords();
	
}
