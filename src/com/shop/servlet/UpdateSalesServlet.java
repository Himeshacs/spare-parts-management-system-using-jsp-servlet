package com.shop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.SalesDao;
import com.shop.model.Sales;

/**
 * Servlet implementation class UpdateSalesServlet
 */
@WebServlet("/UpdateSalesServlet")
public class UpdateSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSalesServlet() {
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
		SalesDao salesDao = new SalesDao();
		Sales sales = new Sales();
		sales.setSalesId(request.getParameter("SalesId"));
		sales.setCustomerId(request.getParameter("CustomerId"));
		sales.setProductId(request.getParameter("ProductId"));
		sales.setQuantity(Integer.parseInt(request.getParameter("Quantity")));
		salesDao.updateSales(sales);
		//request.getRequestDispatcher("page/Sales.jsp").forward(request, response);
		response.sendRedirect("page/Sales.jsp");

	}

}
