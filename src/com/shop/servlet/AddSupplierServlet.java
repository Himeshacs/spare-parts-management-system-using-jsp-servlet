package com.shop.servlet;

//importing built-in packages
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//importing supplier class and dao
import com.shop.model.Supplier;
import com.shop.dao.SupplierDAO;

/**
 * Servlet implementation class AddSupplierServlet
 */
@WebServlet("/AddSupplierServlet")
public class AddSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSupplierServlet() {
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
		PrintWriter pw = response.getWriter();
		
		System.out.println("Supplier" + request.getParameter("supplierID"));
		
		try {
			supplier.setSupplierID(request.getParameter("supplierID"));
			supplier.setCompanyName(request.getParameter("companyName"));
			supplier.setContactPerson(request.getParameter("contactPerson"));
			supplier.setEmail(request.getParameter("email"));
			supplier.setContactNumber(request.getParameter("contactNumber"));
			supplier.setCompanyAddress(request.getParameter("companyAddress"));
			
			System.out.println(supplier.toString());
			SupplierDAO supplierdao = new SupplierDAO();
			
			System.out.println("Supplier Added test");
			supplierdao.addSupplier(supplier);
			response.sendRedirect("Pages/ViewSupplier.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
