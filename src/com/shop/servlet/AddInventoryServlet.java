package com.shop.servlet;

//importing built-in packages
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.IInventoryDao;
//importing inventory class and dao
import com.shop.dao.InventoryDAO;
import com.shop.model.Inventory;

/**
 * Servlet implementation class AddInventoryServlet
 */
@WebServlet("/AddInventoryServlet")
public class AddInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Inventory inventory = new Inventory();
		PrintWriter pw = response.getWriter();
		
		System.out.println("Inventory" + request.getParameter("inventoryID"));
		
		try {
			inventory.setInventoryID(request.getParameter("inventoryID"));
			inventory.setProductID(request.getParameter("productID"));
			inventory.setInstoreInventory(request.getParameter("instoreInventory"));
			inventory.setUnitsPurchased(request.getParameter("unitsPurchased"));
			inventory.setUnitsSold(request.getParameter("unitsSold"));
			inventory.setClosingInventory(request.getParameter("closingInventory"));
			inventory.setUpdateDate(request.getParameter("updateDate"));
			inventory.setUpdateTime(request.getParameter("updateTime"));
			
			System.out.println(inventory.toString());
			IInventoryDao inventorydao = new InventoryDAO();
			
			System.out.println("Invetory Added Test");
			inventorydao.addInventory(inventory);
			response.sendRedirect("Pages/ViewInventory.jsp");
			
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}


