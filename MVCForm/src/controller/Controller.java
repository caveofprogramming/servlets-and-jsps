package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

/**
 * Servlet implementation class for Servlet: Controller
 * 
 */
public class Controller extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} else if (action.equals("login")) {
			
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("validationmessage", "");
			
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} else if (action.equals("dologin")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			
			User user = new User(email, password);
			
			if(user.validate()) {
				request.getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			}
			else {
				request.setAttribute("validationmessage", user.getMessage());
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}
}