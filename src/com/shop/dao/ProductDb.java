package com.shop.dao;
/*AUTHOR : IT19187006
 * S.T.P WEERASOORIYA
 * */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.Query;
import com.mysql.cj.protocol.Resultset;
import com.shop.model.Product;
import com.shop.util.CommonConstants;
import com.shop.util.DbConnection;
import com.shop.util.QueryUtil;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
public class ProductDb implements IProductDb{
	
	
	private static Connection connection;
	private static Logger log = Logger.getLogger(ProductDb.class.getName());
	
	public ProductDb() {
		// TODO Auto-generated constructor stub

	}

	public ArrayList<Product> getProducts() {
		//This arraylist will be return after retrieving data from the db
		ArrayList<Product> products = new ArrayList<Product>();

		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ALL_PRODUCTS));
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Product product = new Product();
				product.setProductId(result.getString("product_id"));
				product.setProductName(result.getString("product_name"));
				product.setGrade(result.getString("grade"));
				product.setType(result.getString("type"));
				product.setBrand(result.getString("brand"));
				product.setModal(result.getString("modal"));
				product.setImagePath(result.getString("image_path"));
				product.setPrice(result.getDouble("price"));
				products.add(product);
			}

			
		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		log.log(Level.SEVERE,"Products fetched from datavase");
		return products;
	}
	

	//insert a product into the db 
	public void saveProduct(Product product) {
		
		try {

			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_PRODUCT));
			statement.setString(1, product.getProductId());
			statement.setString(2, product.getProductName());
			statement.setString(3, product.getGrade());
			statement.setString(4, product.getType());
			statement.setString(5, product.getBrand());
			statement.setString(6, product.getModal());
			statement.setString(7, product.getImagePath());
			statement.setDouble(8, product.getPrice());
			statement.execute();
			log.log(Level.INFO,"Product saved succesfully");


		} catch (ClassNotFoundException | SQLException |SAXException |IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		

	}
	

	//Retrieves number of products from each grade of product
	public void updateProduct(Product product) {
		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_PRODUCT));
			statement.setString(1, product.getProductName());
			statement.setString(2, product.getType());
			statement.setString(3, product.getGrade());
			statement.setString(4, product.getModal());
			statement.setString(5, product.getBrand());
			statement.setString(6, product.getImagePath());
			statement.setDouble(7, product.getPrice());
			statement.setString(8, product.getProductId());

			statement.execute();
		} catch (ClassNotFoundException | SAXException | SQLException | IOException | ParserConfigurationException  e) {
			log.log(Level.SEVERE,e.getMessage());
		}
		log.log(Level.INFO,"Product " + product.getProductId() + "Updated succesfully");
	}
	
	public ArrayList<Integer> getGradeForChart(){
		ArrayList<Integer> gradesCount = new ArrayList<Integer>();

		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PRODUCT_GRADES));
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				gradesCount.add(result.getInt("count"));
			}
			System.out.println("PrdDb : " + gradesCount.size() );
			while(gradesCount.size() <= 3) {
				gradesCount.add(0);
			}
		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE,e.getMessage());
		} 

		return gradesCount;
		
	}
	
	//Returns a product for a given product id
	public Product getProduct(String productId) {
		Product product = new Product();

		try {
			
			connection = DbConnection.getConnection();
			String query = "Select * from product_tab WHERE product_id = " + productId;
			PreparedStatement statement = connection.prepareStatement(query);
			System.out.println(statement.toString());
			ResultSet result = statement.executeQuery();
			result.next();
			product.setProductId(result.getString("product_id"));
			product.setProductName(result.getString("product_name"));
			product.setType(result.getString("type"));
			product.setGrade(result.getString("grade"));
			product.setModal(result.getString("modal"));
			product.setBrand(result.getString("brand"));
			product.setImagePath(result.getString("image_path"));
			product.setPrice(result.getDouble("price"));
			
		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE,e.getMessage());
		}
	
		log.log(Level.SEVERE,"Product " + productId + " returned");

		return product;
	}
	
	//delete a product for a given product id
	public void deleteProduct(String productId) {
		try {
			connection = DbConnection.getConnection();

			String query = "DELETE FROM product_tab WHERE product_id =" + productId ;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, productId);
			System.out.println(statement.toString());
			statement.execute();
			System.out.println("Deleted from product_tab");
		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		
		try {
			if (connection != null)
			connection.close();
		} catch (SQLException e) {
			log.log(Level.SEVERE,"Error!!" + e.getMessage());
		}
		
		log.log(Level.SEVERE,"Product " + productId + " Deleted succesfully");

	}
	

}
