package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.LoginDAO;
import com.chainsys.modal.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
		
		LoginDAO loginDAO = new LoginDAO();

		boolean result;
		try {
			result = loginDAO.validator(login);
			if (result == true) {
				session.setAttribute("NAME", name);
				RequestDispatcher rd = request
						.getRequestDispatcher("applyleave.html");
				rd.forward(request, response);
			} else {
				request.setAttribute("INVALID", "Invalid Name or Password");
				RequestDispatcher rd = request
						.getRequestDispatcher("studentlogin.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
