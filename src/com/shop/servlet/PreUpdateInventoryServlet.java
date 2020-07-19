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
 * Servlet implementation class PreUpdateInventoryServlet
 */
@WebServlet("/PreUpdateInventoryServlet")
public class PreUpdateInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreUpdateInventoryServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		
		try {
			System.out.println("Executes upto A");	
			String inventoryID = request.getParameter("inventoryID");
			IInventoryDao inventorydao = new InventoryDAO();
			System.out.println("Executes upto B"); 
			Inventory inventory = inventorydao.viewInventory(inventoryID);
		
			System.out.println("Executes upto C");
			request.setAttribute("inventory", inventory);
			System.out.println(request.getContextPath());
			request.getRequestDispatcher("Pages/UpdateInventory.jsp").forward(request, response);
			System.out.println("Redirected");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}


