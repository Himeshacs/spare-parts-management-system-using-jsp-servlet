package com.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.model.Inventory;

public interface IInventoryDao {

	//to display all the Inventory records in the database
	ArrayList<Inventory> getInventory() throws SQLException;

	//to delete a inventory record
	void deleteInventory(String inventoryID);

	//updates inventory based on selected Inventory ID
	void updateInventory(Inventory inventory);

	//to add new inventory to the database
	void addInventory(Inventory inventory);

	//to view inventory record by inventory id
	Inventory viewInventory(String inventoryID);

}