package com.shop.dao;

//Importing built-in packages to source file
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//Importing Supplier Class
import com.shop.model.Supplier;
import com.shop.util.CommonConstants;
//Importing DbConnection Util
import com.shop.util.DbConnection;
import com.shop.util.QueryUtil;

public class SupplierDAO {

	//creating connection object
	private static Connection connection;
	private static Logger log = Logger.getLogger(ProductDb.class.getName());

	
	//Default constructor
	public SupplierDAO() {
		
	}
	
	//to display all the supplier records in the database
	public ArrayList<Supplier> getSupplier() throws SQLException{
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
		
		try {
			connection = DbConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ALL_SUPPLIERS));
			System.out.println("Read from Supplier Table");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//creating supplier object
				Supplier supplier = new Supplier();
				
				
				
				supplier.setSupplierID(rs.getString("supplierID"));
				supplier.setCompanyName(rs.getString("companyName"));
				supplier.setContactPerson(rs.getString("contactPerson"));
				supplier.setEmail(rs.getString("email"));
				supplier.setContactNumber( rs.getString("contactNumber"));
				supplier.setCompanyAddress(rs.getString("companyAddress"));
				
				suppliers.add(supplier);
			}
		}catch(Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		
		connection.close();
		return suppliers;
	}
	

	
	//to add new supplier to the database
	public void addSupplier(Supplier supplier) {
		try {
			connection = DbConnection.getConnection();
			System.out.println("Executes upto A");
			
			PreparedStatement ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SUPPLIERS));
			ps.setString(1, supplier.getSupplierID());
			ps.setString(2,supplier.getCompanyName());
			ps.setString(3, supplier.getContactPerson());
			ps.setString(4, supplier.getEmail());
			ps.setString(5, supplier.getContactNumber());
			ps.setString(6, supplier.getCompanyAddress());

			ps.execute();	


		} catch (SQLException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}catch(Exception e) {			
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
}
	}
	
	//updates supplier based on selected supplier ID
	public void updateSupplier(Supplier supplier) {
		try {
			connection = DbConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SUPPLIERS));
			ps.setString(1,supplier.getCompanyName());
			ps.setString(2, supplier.getContactPerson());
			ps.setString(3, supplier.getEmail());
			ps.setString(4, supplier.getContactNumber());
			ps.setString(5, supplier.getCompanyAddress());
			ps.setString(6, supplier.getSupplierID());

			ps.execute();
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
	}
	

	//to view supplier record by supplier id
	public Supplier viewSupplier(String supplierID) {
		Supplier supplier = new Supplier();
		
		try {
			connection = DbConnection.getConnection();
			String sql = "Select * from Supplier where supplierID ='" + supplierID + "'";
			System.out.println(sql);

			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				supplier.setSupplierID(rs.getString("supplierID"));
				supplier.setCompanyName(rs.getString("companyName"));
				supplier.setContactPerson(rs.getString("contactPerson"));
				supplier.setEmail(rs.getString("email"));
				supplier.setContactNumber(rs.getString("contactNumber"));
				supplier.setCompanyAddress(rs.getString("companyAddress"));
			}

		} catch (Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		System.out.println(supplier.getCompanyName());
		return supplier;
	}
	
	
	//to delete supplier record by supplier id
	public void deleteSupplier(String supplierID) {
		try {
			connection = DbConnection.getConnection();
			
			String sql = "Delete from Supplier where supplierID =" +supplierID;
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.execute();
			System.out.println("Supplier Record Removed");
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
	}
}
