package com.shop.servlet;

//importing built-in packages
import java.io.IOException;
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
 * Servlet implementation class PostUpdateInventoryServlet
 */
@WebServlet("/PostUpdateInventoryServlet")
public class PostUpdateInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostUpdateInventoryServlet() {
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
		
		try {
				inventory.setInventoryID(request.getParameter("inventoryID"));
				inventory.setProductID(request.getParameter("inventoryID"));
				inventory.setInstoreInventory(request.getParameter("instoreInventory"));
				inventory.setUnitsPurchased(request.getParameter("unitsPurchased"));
				inventory.setUnitsSold(request.getParameter("unitsSold"));
				inventory.setClosingInventory(request.getParameter("closingInventory"));
				inventory.setUpdateDate(request.getParameter("updateDate"));
				inventory.setUpdateTime(request.getParameter("updateTime"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		IInventoryDao inventorydao = new InventoryDAO();
		inventorydao.updateInventory(inventory);
		response.sendRedirect("Pages/ViewInventory.jsp");
		System.out.println("Records Updated");
		
	}

}


