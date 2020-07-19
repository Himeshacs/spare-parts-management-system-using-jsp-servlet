package com.shop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.UserDao;
import com.shop.model.User;
import com.shop.util.AuthenticateUtil;

/**
 * Servlet implementation class LogServelet
 */
@WebServlet("/LogServelet")
public class LogServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServelet() {
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
		
		String passWord = request.getParameter("passWord");
		String userName = request.getParameter("userName");
		RequestDispatcher requestDispatcher;
		HttpSession session = request.getSession();

		
		UserDao userDao = new UserDao();
		User user = AuthenticateUtil.validateUser(userName,passWord);
		if(user.getUserName() != null) {
			session.setAttribute("user",user);
			response.sendRedirect("page/dashboard.jsp");
			//requestDispatcher = request.getRequestDispatcher("page/dashboard.jsp");
			//requestDispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("page/Login.jsp");

		}

	}

}
