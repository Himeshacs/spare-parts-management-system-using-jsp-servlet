package com.shop.util;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

import com.shop.util.CommonConstants;
import com.shop.util.QueryUtil;

public class Utility {

	public static final Properties properties = new Properties();

	static {
		try {
			
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Utility() {

	}

}
