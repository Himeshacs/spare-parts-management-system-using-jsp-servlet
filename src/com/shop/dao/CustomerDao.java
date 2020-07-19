package com.shop.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.shop.model.Customer;
import com.shop.util.CommonConstants;
import com.shop.util.DbConnection;
import com.shop.util.QueryUtil;

public class CustomerDao {

	private Connection connection;
	private static Logger log = Logger.getLogger(ProductDb.class.getName());

	public CustomerDao() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ALL_CUSTOMERS));
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Customer customer = new Customer();
				customer.setId(result.getString("id"));
				customer.setName(result.getString("name"));
				customer.setPhone(Integer.parseInt(result.getString("phone")));
				customer.setAddress(result.getString("address"));
				customer.setEmail(result.getString("email"));
				customers.add(customer);
				
			}
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		return customers;
	}
	

	
	public void addCustomer(Customer customer) {
	try {
		connection = DbConnection.getConnection();
		String query = "INSERT INTO CUSTOMER_TAB VALUES(?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CUSTOMERS));
		statement.setString(1, customer.getId());
		statement.setString(2, customer.getName());
		statement.setInt(3, customer.getPhone());
		statement.setString(4, customer.getAddress());
		statement.setString(5, customer.getEmail());
		statement.execute();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		log.log(Level.SEVERE,"Error!!" + e.getMessage());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		log.log(Level.SEVERE,"Error!!" + e.getMessage());
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		log.log(Level.SEVERE,"Error!!" + e.getMessage());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		log.log(Level.SEVERE,"Error!!" + e.getMessage());
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		log.log(Level.SEVERE,"Error!!" + e.getMessage());
	}


		
	}
	
	
	public void updateCustomer(Customer customer) {


		try {
			connection = DbConnection.getConnection();
			String query = "UPDATE CUSTOMER_TAB SET NAME = ?,PHONE = ?,ADDRESS = ?,EMAIL = ? WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CUSTOMERS));
			statement.setString(1, customer.getName());
			statement.setInt(2, customer.getPhone());
			statement.setString(3, customer.getAddress());
			statement.setString(5, customer.getEmail());
			statement.setString(4, customer.getId());

			statement.execute();
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		
	}
	
	public Customer getCustomer(String id) {
		Customer customer = new Customer();
		try {
			connection = DbConnection.getConnection();
			String query = "SELECT * FROM CUSTOMER_tab WHERE ID = " + id;
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			result.next();
			customer.setId(result.getString("id"));
			customer.setName(result.getString("name"));
			customer.setPhone(Integer.parseInt(result.getString("phone")));
			customer.setAddress(result.getString("address"));
			customer.setEmail(result.getString("email"));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;

	}

	
	public void deleteCustomer(String Id) {
		try {
			connection = DbConnection.getConnection();
			String query = "DELETE FROM CUSTOMER_TAB WHERE ID =" + Id;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
