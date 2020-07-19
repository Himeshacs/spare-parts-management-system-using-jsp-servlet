	package com.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


 public class DbConnection extends Utility{

	private static Connection connection;
	public DbConnection() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		
		if (connection == null || connection.isClosed()) {
			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			System.out.println(properties.getProperty(CommonConstants.URL));
			System.out.println(properties.getProperty(CommonConstants.USERNAME));
			connection = DriverManager.getConnection(
						 properties.getProperty(CommonConstants.URL),
						 properties.getProperty(CommonConstants.USERNAME),
						 properties.getProperty(CommonConstants.PASSWORD)
						 );
		}
		return connection;
	}
}
