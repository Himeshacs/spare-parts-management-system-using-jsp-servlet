package com.shop.dao;
/*AUTHOR : IT19187006
 * S.T.P WEERASOORIYA
 * */
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.shop.model.Sales;
import com.shop.util.CommonConstants;
import com.shop.util.DbConnection;
import com.shop.util.QueryUtil;

public class SalesDao {

	private static Connection connection; 
	private static Logger log = Logger.getLogger(ProductDb.class.getName());

	public SalesDao() {
		// TODO Auto-generated constructor stub
	}
	//returns all the sales records in sales_tab table in the database
	public ArrayList<Sales> getSalesRecords(){
		ArrayList<Sales> saleslist = new ArrayList<Sales>();
		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ALL_SALES));
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				Sales sales = new Sales();
				sales.setSalesId(result.getString("salesId"));
				sales.setProductId(result.getString("productId"));
				sales.setCustomerId(result.getString("customerId"));
				sales.setQuantity(result.getInt("quantity"));
				
				sales.setDate(result.getString("date"));//when no date null exception occurs
				sales.setTotal((result.getDouble("total")));
				
				saleslist.add(sales);
			}
		} catch (ClassNotFoundException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		log.log(Level.SEVERE,"All sales records retrieved from database");
		return saleslist;
	}
	

	//Inserts a record into the sales table
	public void addSales(Sales sales) {
		try {
			connection = DbConnection.getConnection();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));   
			String date = dtf.format(now);
			//query to enter sales
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SALES));
			//query to reduce from inventory
			PreparedStatement statement2 = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REDUCE_FROM_INVENTORY));
			connection.setAutoCommit(false);
			statement.setString(1, sales.getSalesId());
			statement.setString(2, sales.getCustomerId());
			statement.setString(3, sales.getProductId());
			statement.setInt(4, sales.getQuantity());
			statement.setString(5, date);
			statement2.setInt(1,sales.getQuantity());
			statement2.setString(2, sales.getProductId());
			
			System.out.println(statement);
			statement2.execute();
			statement.execute();
			connection.commit();
		} catch (ClassNotFoundException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		} catch (SQLException e) {			
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		} catch (SAXException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		} catch (IOException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		} catch (ParserConfigurationException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		}
		
		log.log(Level.SEVERE,"Sales record " + sales.getSalesId() + "added succesfully" );

	}
	
	//updates a row in the sales table for a given sales object
	public void updateSales(Sales sales) {
		try {
			connection = DbConnection.getConnection();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			System.out.println(dtf.format(now));   
			String date = dtf.format(now);
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SALES));
			statement.setString(1, sales.getCustomerId());
			statement.setString(2, sales.getProductId());
			statement.setInt(3, sales.getQuantity());
			statement.setString(4, date);
			statement.setString(5, sales.getSalesId());
			statement.execute();
		} catch (ClassNotFoundException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		} catch (SQLException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		} catch (SAXException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		} catch (IOException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		} catch (ParserConfigurationException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		}

		log.log(Level.SEVERE,"Sales record " + sales.getSalesId() + "updated  succesfully");

	}

	//deletes a record in the database for a given sales id
	public void deleteSalesRecord(String salesId) {
		try {
			System.out.print(salesId);
			connection = DbConnection.getConnection();
			String query = 	 "DELETE FROM SALES_TAB "
						   + "WHERE SALESID = " + salesId;
			PreparedStatement statement = connection.prepareStatement(query);
			System.out.print(query);

			statement.execute();
		} catch (ClassNotFoundException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		} catch (SQLException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		}
		
		log.log(Level.SEVERE,"Sales record " + salesId + "Deleted succesfully");

	}
	//returns a sales object for a given sales id
	public Sales getSalesRecord(String salesId) {
		Sales sales = new Sales();
		System.out.println("salesDao getSalesRecord " + salesId);
		try {
			connection = DbConnection.getConnection();
			String query = "SELECT * FROM SALES_TAB " +
							"WHERE SALESID = " + salesId;
			//PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_Sales));
			//statement.setString(1, salesId);
			PreparedStatement statement = connection.prepareStatement(query);
			System.out.println(statement);

			ResultSet result = statement.executeQuery();
			result.next();
			sales.setSalesId(result.getString("SalesId"));
			sales.setProductId(result.getString("ProductId"));
			sales.setQuantity(result.getInt("quantity"));
			sales.setCustomerId(result.getString("CustomerId"));
			
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		
		log.log(Level.SEVERE,"Sales record " + salesId + " returned ");
		return sales;
	}

}
