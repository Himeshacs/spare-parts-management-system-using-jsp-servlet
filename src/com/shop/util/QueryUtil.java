package com.shop.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.shop.util.Utility;
import com.shop.util.CommonConstants;

public class QueryUtil extends Utility {

	public QueryUtil() {
	}
	
	public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nodeList;
		Element element = null;

		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\Assignment\\WEB-INF\\Query.xml"))
				.getElementsByTagName(CommonConstants.TAG_NAME);


		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			if (element.getAttribute(CommonConstants.ATTRIB_ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}
}


