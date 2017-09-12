package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.User;
import database.Account;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			InitialContext initContext = new InitialContext();

			Context env = (Context) initContext.lookup("java:comp/env");

			ds = (DataSource) env.lookup("jdbc/webshop");

		} catch (NamingException e) {
			throw new ServletException();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");

		if (action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if(action.equals("login")) {
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else if(action.equals("createaccount")) {
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("repeatpassword", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
		}
		else {
			out.println("unrecognised action");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// use connection
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");

		if (action == null) {
			out.println("unrecognised action");
			return;
		}

		Connection conn = null;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			out.println("Unable to connect to database.");
			System.out.println("Unable to connect to database.");
			return;
			//throw new ServletException();
		}

		Account account = new Account(conn);
		
		if(action.equals("dologin")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User user = new User(email, password);
			
			request.setAttribute("email", email);
			request.setAttribute("password", "");
			
			try {
				if(account.login(email, password)) {
					request.getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
				}
				else {
					request.setAttribute("message", "email address or password not recognised");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				request.setAttribute("email", "Database error: please try again later.");
				request.getRequestDispatcher("/newaccount.jsp").forward(request, response);
			}
			
		}
		else if(action.equals("createaccount")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String repeatPassword = request.getParameter("repeatpassword");
			
			request.setAttribute("email", email);
			request.setAttribute("password", "");
			request.setAttribute("repeatpassword", "");
			request.setAttribute("message", "");
			
			if(!password.equals(repeatPassword)) {
				// Passwords don't match.
				request.setAttribute("message", "Passwords do not match.");
				request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
			}
			else {
				User user = new User(email, password);
				
				if(!user.validate()) {
					// Password or email address has wrong format.
					request.setAttribute("message", user.getMessage());
					request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
				}
				else {
					try {
						if(account.exists(email)) {
							// This email address already exists in the user database.
							request.setAttribute("message", "An account with this email address already exists");
							request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
						}
						else {
							// We create create the account.
							account.create(email, password);
							request.getRequestDispatcher("/createsuccess.jsp").forward(request, response);
						}
					} catch (SQLException e) {
						
						request.getRequestDispatcher("/error.jsp").forward(request, response);
					}
				}
				
			}
		}
		else {
			out.println("unrecognised action");
		}
		

		try {
			conn.close();
		} catch (SQLException e) {
			throw new ServletException();
		}
	}
	
	public void createAccount() {
		
	}

}
