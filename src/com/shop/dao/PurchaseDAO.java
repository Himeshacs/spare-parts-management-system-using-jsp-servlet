package com.shop.dao;

//Importing built-in packages to source file
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//Importing Purchase Class
import com.shop.model.Purchase;
import com.shop.util.CommonConstants;
//Importing DbConnection Util
import com.shop.util.DbConnection;
import com.shop.util.QueryUtil;

public class PurchaseDAO implements IPurchaseDao {

	//creating connection object
	private static Connection connection;
	private static Logger log = Logger.getLogger(ProductDb.class.getName());

	//Default Constructor 
	public PurchaseDAO() {
		
	}
	
	//to display all the Inventory records in the database
	@Override
	public ArrayList<Purchase> getPurchase() throws SQLException{
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		
		try {
			connection = DbConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ALL_PURCHASE));
			System.out.println("Read from Purchase Table");
			ResultSet rs = ps.executeQuery();
			
				
			while(rs.next()) {
				//creating purchase object
				Purchase purchase = new Purchase();
				
				purchase.setPurchaseID(rs.getString("purchaseID"));
				purchase.setSupplierID(rs.getString("supplierID"));
				purchase.setProductID(rs.getString("productID"));
				purchase.setUnitPrice(rs.getString("unitPrice"));
				purchase.setTotalQuantity(rs.getString("totalQuantity"));
				purchase.setSubTotal(rs.getString("subTotal"));
				purchase.setPurchaseStatus(rs.getString("purchaseStatus"));
				purchase.setPurchaseDate(rs.getString("purchaseDate"));
				
				purchases.add(purchase);
			}
		}catch(Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		
		connection.close();
		return purchases;
	}
	
	//to add new purchase to the database
	@Override
	public void addPurchase(Purchase purchase) {
		try {
			connection = DbConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_PURCHASE));
			ps.setString(1, purchase.getPurchaseID());
			ps.setString(2, purchase.getSupplierID());
			ps.setString(3,purchase.getProductID() );
			ps.setString(4,purchase.getUnitPrice() );
			ps.setString(5, purchase.getTotalQuantity());
			ps.setString(6,  purchase.getSubTotal());
			ps.setString(7,purchase.getPurchaseStatus() );
			ps.setString(8,purchase.getPurchaseDate());
			
			ps.execute();	


		} catch (SQLException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}catch(Exception e) {			
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
}
	}
	
	//updates purchase based on selected purchase ID
	@Override
	public void updatePurchase(Purchase purchase) {
		try {
			connection = DbConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_PURCHASE));

			ps.setString(1, purchase.getSupplierID());
			ps.setString(2, purchase.getProductID());
			ps.setString(3, purchase.getUnitPrice());
			ps.setString(4,purchase.getTotalQuantity());
			ps.setString(5, purchase.getSubTotal());
			ps.setString(6, purchase.getPurchaseStatus());
			ps.setString(7, purchase.getPurchaseDate());
			ps.setString(8,purchase.getPurchaseID());
			
			ps.execute();
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
	}
	
	//to delete purchase record by purchase id
	@Override
	public void deletePurchase(String purchaseID) {
		try {
			connection = DbConnection.getConnection();
			
			String sql = "Delete from Purchase where purchaseID =" +purchaseID;
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.execute();
			System.out.println("Purchase Record Removed");
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
	}
	

	
	//to view purchase record by purchase id
	@Override
	public Purchase viewPurchase(String purchaseID) {
		Purchase purchase = new Purchase();
		
		try {
			connection = DbConnection.getConnection();
			String sql = "Select * from purchase where purchaseID =" + purchaseID;
			System.out.println(sql);
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				purchase.setPurchaseID(rs.getString("purchaseID"));
				purchase.setSupplierID(rs.getString("supplierID"));
				purchase.setProductID(rs.getString("productID"));
				purchase.setUnitPrice(rs.getString("unitPrice"));
				purchase.setTotalQuantity(rs.getString("totalQuantity"));
				purchase.setSubTotal(rs.getString("subTotal"));
				purchase.setPurchaseStatus(rs.getString("purchaseStatus"));
				purchase.setPurchaseDate(rs.getString("purchaseDate"));
				
			}
			
		}catch (Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());		
	}
		return purchase;

	}
}

