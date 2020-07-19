package com.shop.servlet;

//importing built-in packages
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.IInventoryDao;
//importing inventory dao
import com.shop.dao.InventoryDAO;

/**
 * Servlet implementation class DeleteInventoryServlet
 */
@WebServlet("/DeleteInventoryServlet")
public class DeleteInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInventoryServlet() {
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
		
		String inventoryID = request.getParameter("inventoryID");
		System.out.println(inventoryID);
		
		IInventoryDao inventorydao = new InventoryDAO();
		inventorydao.deleteInventory(inventoryID);
		response.sendRedirect("Pages/ViewInventory.jsp");
		
	}

}
