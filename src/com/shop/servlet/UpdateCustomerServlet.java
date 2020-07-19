package com.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.CustomerDao;
import com.shop.dao.SalesDao;
import com.shop.model.Customer;
import com.shop.model.Sales;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
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

		CustomerDao customerDao = new CustomerDao();
		Customer customer = new Customer();
		customer.setId(request.getParameter("CustomerId"));
		customer.setAddress(request.getParameter("CustomerAddress"));
		customer.setEmail(request.getParameter("Email"));
		customer.setName(request.getParameter("CustomerName"));
		customer.setPhone(Integer.parseInt(request.getParameter("CustomerPhone")));
		customerDao.updateCustomer(customer);
		System.out.println(customer.toString());
		response.sendRedirect("page/Customers.jsp");
	}

}
