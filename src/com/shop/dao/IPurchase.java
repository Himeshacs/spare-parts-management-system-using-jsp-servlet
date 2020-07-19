package com.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.model.Purchase;

public interface IPurchase {

	ArrayList<Purchase> getPurchase() throws SQLException;

	void deletePurchase(String purchaseID);

	void addPurchase(Purchase purchase);

	Purchase viewPurchase(String purchaseID);

	void updatePurchase(Purchase purchase);

}