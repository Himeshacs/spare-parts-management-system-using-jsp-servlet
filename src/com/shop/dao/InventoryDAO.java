package com.shop.dao;

//Importing built-in packages to source file
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//Importing Inventory Class
import com.shop.model.Inventory;
import com.shop.util.CommonConstants;
//Importing DbConnection Util
import com.shop.util.DbConnection;
import com.shop.util.QueryUtil;

public class InventoryDAO implements IInventoryDao {
	
	//creating connection object
	private static Connection connection;
	private static Logger log = Logger.getLogger(ProductDb.class.getName());

	
	//Default Constructor 
	public InventoryDAO() {
		
	}
	
	//to display all the Inventory records in the database
	@Override
	public ArrayList<Inventory> getInventory() throws SQLException{
		ArrayList<Inventory> inventorys = new ArrayList<Inventory>();
		
		try {
			connection = DbConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ALL_INVENTORY));
			System.out.println("Read from Inventory Table"); 
			ResultSet rs = ps.executeQuery();
			
				
			while(rs.next()) {
				//creating inventory object
				Inventory inventory = new Inventory();
				
				inventory.setInventoryID(rs.getString("inventoryID"));
				inventory.setProductID(rs.getNString("productID"));
				inventory.setInstoreInventory(rs.getString("instoreInventory"));
				inventory.setUnitsPurchased(rs.getString("unitsPurchased"));
				inventory.setUnitsSold(rs.getString("unitsSold"));
				inventory.setClosingInventory(rs.getString("closingInventory"));
				inventory.setUpdateDate(rs.getString("updateDate"));
				inventory.setUpdateTime(rs.getString("updateTime"));
				
				inventorys.add(inventory);		
				
			}
		}catch(Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		
		connection.close();
		return inventorys;
	}
	
	//to delete a inventory record
	@Override
	public void deleteInventory(String inventoryID) {
		try {
			connection = DbConnection.getConnection();
			String sql = "Delete from Inventory where inventoryID =" +inventoryID;
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.execute();
			log.log(Level.SEVERE,"Inventory Record Removed");

		} catch (Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
	}
	
	
	//updates inventory based on selected Inventory ID
	@Override
	public void updateInventory(Inventory inventory) {
		try {
			connection = DbConnection.getConnection();

			
			PreparedStatement ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_INVENTORY));
			ps.setString(1, inventory.getProductID());
			ps.setString(2, inventory.getInstoreInventory());
			ps.setString(3, inventory.getUnitsPurchased());
			ps.setString(4, inventory.getUnitsSold());
			ps.setString(5, inventory.getClosingInventory());
			ps.setString(6, inventory.getUpdateDate());
			ps.setString(7, inventory.getUpdateTime());
			ps.setString(8, inventory.getInventoryID());

			ps.execute();
			
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
	}
	
	//to add new inventory to the database
	@Override
	public void addInventory(Inventory inventory) {
		try {
			connection = DbConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_INVENTORY));
			ps.setString(1, inventory.getInventoryID());
			ps.setString(2, inventory.getProductID());
			ps.setString(3, inventory.getInstoreInventory());
			ps.setString(4, inventory.getUnitsPurchased());
			ps.setString(5, inventory.getUnitsSold());
			ps.setString(6, inventory.getClosingInventory());
			ps.setString(7, inventory.getUpdateDate());
			ps.setString(8, inventory.getUpdateTime());

			ps.execute();	
			System.out.println("Executes upto C");


		} catch (SQLException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}catch(Exception e) {			
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
}
	}
	
	//to view inventory record by inventory id
	@Override
	public Inventory viewInventory(String inventoryID) {
		Inventory inventory = new Inventory();
		
		try {
			connection = DbConnection.getConnection();
			String sql = "Select * from Inventory where inventoryID =" + inventoryID;
			System.out.println(sql);
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				inventory.setInventoryID(rs.getString("inventoryID"));
				inventory.setProductID(rs.getString("productID"));
				inventory.setInstoreInventory(rs.getString("instoreInventory"));
				inventory.setUnitsPurchased(rs.getString("unitsPurchased"));
				inventory.setUnitsSold(rs.getString("unitsSold"));
				inventory.setClosingInventory(rs.getString("closingInventory"));
				inventory.setUpdateDate(rs.getString("updateDate"));
				inventory.setUpdateTime(rs.getString("updateTime"));
			}

		} catch (Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		
		return inventory;
	}

	
}
