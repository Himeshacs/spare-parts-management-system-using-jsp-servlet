package com.shop.util;
/*AUTHOR : IT19187006
 * S.T.P WEERASOORIYA
 * */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.mysql.cj.protocol.Resultset;
import com.shop.dao.ProductDb;

public class DashUtill {

	public DashUtill() {
		// TODO Auto-generated constructor stub
	}

	private static Logger log = Logger.getLogger(DashUtill.class.getName());
	HashMap<String,String> dashboardData = new HashMap<String, String>();
	Connection connection;
	
	public HashMap<String,String> getDashBoardData(){
	
	
		dashboardData.put("dailySales", Double.toString(getDailySales()));
		dashboardData.put("weeklySales", Double.toString(getWeeklySales()));
		dashboardData.put("monthlySales",Double.toString(getMonthlySales()));
		double[] dailySalesOfWeek = getSalesForDaysOfWeek();
		dashboardData.put("SundaySales",Double.toString(dailySalesOfWeek[0]));
		dashboardData.put("MondaySales",Double.toString(dailySalesOfWeek[1]));
		dashboardData.put("TuesdaySales",Double.toString(dailySalesOfWeek[2]));
		dashboardData.put("WednesdaySales",Double.toString(dailySalesOfWeek[3]));
		dashboardData.put("ThursdaySales",Double.toString(dailySalesOfWeek[4]));
		dashboardData.put("FridaySales",Double.toString(dailySalesOfWeek[5]));
		dashboardData.put("SaturdaySales",Double.toString(dailySalesOfWeek[6]));
		

		return dashboardData;
		
	}
	
	public double getDailySales() {
		Double retVal = 0.0;
		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DAILY_SALES));
			ResultSet result = statement.executeQuery();
			while(result.next()) {
			retVal = result.getDouble(1);
			}
			
		} catch (ClassNotFoundException |SQLException | SAXException|IOException |ParserConfigurationException e) {
			log.log(Level.SEVERE,e.getMessage());
		}
		return retVal;
		
	}
	
	public double getWeeklySales() {
		Double retVal = 0.0;
		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_WEEKLY_SALES));
			ResultSet result = statement.executeQuery();
			while(result.next()) {
			retVal = result.getDouble(1);
			}
			
		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE,e.getMessage());
		}
		return retVal;
		
	}
	
	public double getMonthlySales() {
		Double retVal = 0.0;
		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_MONTHLY_SALES));
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
			retVal = result.getDouble(1);
			}
			
		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE,e.getMessage());
		}
		return retVal;
		
	}
	
	public double[] getSalesForDaysOfWeek(){
		double[] retVal = {0,0,0,0,0,0,0};
		try {
			connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SALES_PER_DAY));
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getDouble("total"));
				switch (result.getInt("day")){
					case  0 :
						retVal[0] = result.getDouble("total"); 
						break;
					case 1 : 
						retVal[1] = result.getDouble("total"); 
						break;
					case 2 :
						retVal[2] = result.getDouble("total"); 
						break;
					case 3 :
						retVal[3] = result.getDouble("total"); 
						break;
					case 4 :
						retVal[4] = result.getDouble("total"); 
						break;
					case 5 :
						retVal[5] = result.getDouble("total"); 
						break;
					case 6 :
						retVal[6] = result.getDouble("total"); 
						break;

				}
			}
			
		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return retVal;

	}

}
