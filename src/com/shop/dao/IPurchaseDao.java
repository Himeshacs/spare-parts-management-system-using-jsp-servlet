package com.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.model.Purchase;

public interface IPurchaseDao {

	//to display all the Inventory records in the database
	ArrayList<Purchase> getPurchase() throws SQLException;

	//to add new purchase to the database
	void addPurchase(Purchase purchase);

	//updates purchase based on selected purchase ID
	void updatePurchase(Purchase purchase);

	//to delete purchase record by purchase id
	void deletePurchase(String purchaseID);

	//to view purchase record by purchase id
	Purchase viewPurchase(String purchaseID);

}