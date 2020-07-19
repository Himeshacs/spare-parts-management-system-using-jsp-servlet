package com.shop.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
 * Servlet implementation class PostUpdateServlet
 */
@WebServlet("/PostUpdateServlet")
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostUpdateServlet() {
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
		ProductDb productDb = new ProductDb();
		FileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemFactory);		
		try {
			List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
			for(FileItem item : items) {
				boolean isFormField = item.isFormField();
				if(isFormField) {
					if(item.getFieldName().equals("productId")) {
						System.out.println("prod_Id" + item.getString());
						 product = productDb.getProduct(item.getString());
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
				}
				else {
					if(item.getSize() > 2) {
					File uploadDir = new File("D:\\EclipseWorkspace\\Assignment\\WebContent\\assets\\images\\products");
					File file = File.createTempFile("img",".png",uploadDir);
					String imagePath = "../assets/images/products/" + file.getName() ;
					item.write(file);
					product.setImagePath(imagePath);
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productDb.updateProduct(product);
		System.out.println("product updated");
		response.sendRedirect("page/products.jsp");
	}

}
