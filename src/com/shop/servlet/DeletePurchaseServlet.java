package com.shop.servlet;

//importing built-in packages
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.IPurchaseDao;
//importing purchase dao
import com.shop.dao.PurchaseDAO;

/**
 * Servlet implementation class DeletePurchaseServlet
 */
@WebServlet("/DeletePurchaseServlet")
public class DeletePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePurchaseServlet() {
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
		
		String purchaseID = request.getParameter("purchaseID");
		System.out.println(purchaseID);
		
		IPurchaseDao purchasedao = new PurchaseDAO();
		purchasedao.deletePurchase(purchaseID);
		response.sendRedirect("Pages/ViewPurchase.jsp");
		
	}

}
