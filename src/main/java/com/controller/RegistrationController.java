package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.student;
import com.dao.StudentDao;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegistrationController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String middlename = request.getParameter("middlename");
		String lastname = request.getParameter("lastname");
		String mobileno = request.getParameter("mobile");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmpsw = request.getParameter("confirmpassword");

		System.out.println(middlename + "" + lastname + "" + address);
		student st = new student();
		st.setFirstname(firstname);
		st.setMiddlename(middlename);
		st.setLastname(lastname);
		st.setMobileno(mobileno);
		st.setEmail(email);
		st.setAddress(address);
		st.setUsername(username);
		st.setPassword(password);
		st.setRetypepsw(confirmpsw);

		System.err.println(st);
		StudentDao dao = new StudentDao();
		int status =dao.insert(st);
		if(status>0) {
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		}
	}


}
