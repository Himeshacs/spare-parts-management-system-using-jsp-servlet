package com.shop.servlet;

//importing built-in packages
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.IPurchaseDao;
//importing purchase class and dao
import com.shop.dao.PurchaseDAO;
import com.shop.model.Purchase;


/**
 * Servlet implementation class PreUpdatePurchaseServlet
 */
@WebServlet("/PreUpdatePurchaseServlet")
public class PreUpdatePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreUpdatePurchaseServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("Executes upto A");
		String purchaseID = request.getParameter("purchaseID");
		IPurchaseDao purchasedao = new PurchaseDAO();
		System.out.println("Executes upto B"); 
		Purchase purchase = purchasedao.viewPurchase(purchaseID);
		
		System.out.println("Executes upto C");
		request.setAttribute("purchase", purchase);
		System.out.println(request.getContextPath());
		System.out.println(purchase.toString());
		request.getRequestDispatcher("Pages/UpdatePurchase.jsp").forward(request, response);
		System.out.println("Redirected");
		} catch  (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}




