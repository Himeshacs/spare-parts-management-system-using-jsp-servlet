package com.shop.servlet;

//importing built-in packages
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//importing supplier class and dao
import com.shop.dao.SupplierDAO;
import com.shop.model.Supplier;

/**
 * Servlet implementation class PostUpdateSupplierServlet
 */
@WebServlet("/PostUpdateSupplierServlet")
public class PostUpdateSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostUpdateSupplierServlet() {
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
		
		Supplier supplier = new Supplier();
		
		try {
				System.out.println("In posupd sup)");
				
				supplier.setSupplierID(request.getParameter("supplierID"));
				supplier.setCompanyName(request.getParameter("companyName"));
				supplier.setContactPerson(request.getParameter("contactPerson"));
				supplier.setEmail(request.getParameter("email"));
				supplier.setContactNumber(request.getParameter("contactNumber"));
				supplier.setCompanyAddress(request.getParameter("companyAddress"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		SupplierDAO supplierdao = new SupplierDAO();
		supplierdao.updateSupplier(supplier);
		response.sendRedirect("Pages/ViewSupplier.jsp");
		System.out.println("Records Updated");
		
	}

}
