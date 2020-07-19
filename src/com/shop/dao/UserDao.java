package com.shop.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.shop.model.User;
import com.shop.util.CommonConstants;
import com.shop.util.DbConnection;
import com.shop.util.QueryUtil;

public class UserDao {

	private Connection connection;
	private static Logger log = Logger.getLogger(ProductDb.class.getName());

	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	
	public void addUser(User user) {
		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_USERS));
			statement.setString(1, user.getName());
			statement.setString(2,user.getEmail());
			statement.setString(3, user.getUserName());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getRole());
			System.out.println(statement);
			statement.execute();
		} catch (ClassNotFoundException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		} catch (SQLException e) {
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
	

	
	
	public void updateUser(User user) {
		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_USERS));
			statement.setString(1, user.getName());
			statement.setString(2,user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getRole());
			statement.setString(5, user.getUserName());
			System.out.println(statement);

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
	
	public ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<User>();
		try {
			
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ALL_USERS));
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				User user = new User();
				user.setUserName(result.getString("username"));
				user.setEmail(result.getString("email"));
				user.setPassword(result.getString("password"));
				user.setRole(result.getString("userrole"));
				user.setName(result.getString("name"));
				users.add(user);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		} catch (SAXException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		} catch (IOException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		} catch (ParserConfigurationException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());

		}
		
		return users;
	}
	
	
	public User getUser(String username) {
		User user = new User();
		try {
		connection = DbConnection.getConnection();
		String query = "select * from user_tab where username = "+ username ;
		PreparedStatement statement = connection.prepareStatement(query);
		System.out.println(statement);
		ResultSet result = statement.executeQuery();
		result.next();
		
			user.setUserName(result.getString("userName"));
			user.setEmail(result.getString("email"));
			user.setName(result.getString("name"));
			user.setRole(result.getString("userrole"));
			user.setPassword(result.getString("password"));
		}catch(Exception e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		return user;
			
	}
	
	public void deleteUser(String username) {
		try {
			connection = DbConnection.getConnection();
			String query = "DELETE FROM USER_TAB WHERE USERNAME = " + username;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.execute();
		} catch (ClassNotFoundException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		} catch (SQLException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
	}
	
}