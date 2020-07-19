package com.shop.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.shop.dao.ProductDb;
import com.shop.model.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		Product product = new Product();
		PrintWriter print = response.getWriter();
		FileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemFactory);
		System.out.println(request.getParameter("productId"));

		try {
			List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
			for(FileItem item : items) {
				String contentType = item.getContentType();
				boolean isFormField = item.isFormField();
				if(isFormField) {
					if(item.getFieldName().equals("productId")) {
						System.out.println(item.getString());
						product.setProductId(item.getString());
					}
					else if(item.getFieldName().equals("productName")) {
						product.setProductName(item.getString());
					}
					else if(item.getFieldName().equals("type")) {
						product.setType(item.getString());
					}
					else if(item.getFieldName().equals("grade")) {
						product.setGrade(item.getString());
					}
					else if(item.getFieldName().equals("brand")) {
						product.setBrand(item.getString());
					}
					else if(item.getFieldName().equals("modal")) {
						product.setModal(item.getString());
					}
					else if(item.getFieldName().equals("Price")) {
						product.setPrice(Double.parseDouble(item.getString()));
					}
				}else {
					
					File uploadDir = new File("D:\\EclipseWorkspace\\Assignment\\WebContent\\assets\\images\\products");
					File file = File.createTempFile("img",".jpg",uploadDir);
					String imagePath = "../assets/images/products/" + file.getName() ;
					product.setImagePath(imagePath);
					item.write(file);
					System.out.println("File Uploaded");
				}
				
			}
		} catch (Exception e) {

			System.out.println("Error " + e.getMessage());
		}
		ProductDb productDb = new ProductDb();
		productDb.saveProduct(product);
		response.sendRedirect("page/products.jsp");

		
	}

}
