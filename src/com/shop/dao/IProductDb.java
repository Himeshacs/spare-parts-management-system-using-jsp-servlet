package com.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.model.Product;

public interface IProductDb {

	public ArrayList<Integer> getGradeForChart();
	public void updateProduct(Product product);
	public Product getProduct(String productId) throws SQLException;
	public void saveProduct(Product product);
	public void deleteProduct(String productId);
	public ArrayList<Product> getProducts();
}
