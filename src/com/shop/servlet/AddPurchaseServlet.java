package com.shop.servlet;

//importing built-in packages
import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AddPurchaseServlet
 */
@WebServlet("/AddPurchaseServlet")
public class AddPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPurchaseServlet() {
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
		
		Purchase purchase = new Purchase();
		PrintWriter pw = response.getWriter();
		
		System.out.println("Purchase" + request.getParameter("purchaseID"));
		
		try {
			purchase.setPurchaseID(request.getParameter("purchaseID"));
			purchase.setSupplierID(request.getParameter("supplierID"));
			purchase.setProductID(request.getParameter("productID"));
			purchase.setUnitPrice(request.getParameter("unitPrice"));
			purchase.setTotalQuantity(request.getParameter("totalQuantity"));
			purchase.setSubTotal(request.getParameter("subTotal"));
			purchase.setPurchaseStatus(request.getParameter("purchaseStatus"));
			purchase.setPurchaseDate(request.getParameter("purchaseDate"));
			
			System.out.println(purchase.toString());
			IPurchaseDao purchasedao = new PurchaseDAO();
	
			System.out.println("Purchase Added Test");
			purchasedao.addPurchase(purchase);
			response.sendRedirect("Pages/ViewPurchase.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}


