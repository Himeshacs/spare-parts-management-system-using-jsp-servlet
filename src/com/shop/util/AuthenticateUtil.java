package com.shop.util;
/*IT19187006
S.t.p weerasooriya*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shop.model.User;

public class AuthenticateUtil {

	public AuthenticateUtil() {
		// TODO Auto-generated constructor stub
	}

	public static User validateUser(String userName,String password) {
		System.out.println(userName + "  " + password);
		User user = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DbConnection.getConnection();
			String query = "select * from user_tab where username ='" + userName +"' and password ='" + password + "'";
			PreparedStatement statement = connection.prepareStatement(query);
			System.out.println("abc");
			ResultSet result = statement.executeQuery();
			result.next();
			
			if ( result.getString("userName") != null ) {
				user.setUserName(result.getString("userName"));
				user.setEmail(result.getString("email"));
				user.setName(result.getString("name"));
				user.setRole(result.getString("userrole"));
			}
			else 
			
			System.out.println("abc" + result.getString("userName"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
