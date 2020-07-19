package com.shop.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.ProductDb;
import com.shop.dao.SalesDao;
import com.shop.model.Product;
import com.shop.model.Sales;

/**
 * Servlet implementation class AddSalesServlet
 */
@WebServlet("/AddSalesServlet")
public class AddSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSalesServlet() {
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			Sales sales = new Sales();
			sales.setSalesId(request.getParameter("SalesId"));
			sales.setCustomerId(request.getParameter("CustomerId"));
			sales.setProductId(request.getParameter("ProductId"));
			ProductDb productDb = new ProductDb();
			Product product = productDb.getProduct(request.getParameter("ProductId"));
			double total = product.getPrice() * Double.parseDouble(request.getParameter("Quantity"));
			sales.setQuantity(Integer.parseInt(request.getParameter("Quantity")));
			sales.setTotal(total);

			SalesDao salesDao = new SalesDao();
			salesDao.addSales(sales);
			response.sendRedirect("page/Sales.jsp");

			//request.getRequestDispatcher("page/Sales.jsp").forward(request, response);
	}

}
