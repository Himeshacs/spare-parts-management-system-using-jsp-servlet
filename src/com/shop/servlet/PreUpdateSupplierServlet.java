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
 * Servlet implementation class PreUpdateSupplierServlet
 */
@WebServlet("/PreUpdateSupplierServlet")
public class PreUpdateSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreUpdateSupplierServlet() {
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
			String supplierID = request.getParameter("supplierID");
			SupplierDAO supplierdao = new SupplierDAO();
			Supplier supplier = supplierdao.viewSupplier(supplierID);
			
			System.out.println("Executes upto B");
			request.setAttribute("supplier", supplier);
			System.out.println(request.getContextPath());
			request.getRequestDispatcher("Pages/UpdateSupplier.jsp").forward(request, response);
			System.out.println("Redirected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
System.out.println(e.getLocalizedMessage());
}
		
	}

}
