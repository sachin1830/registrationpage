package com.org.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.model.Registration;
import com.org.model.RegistrationDao;

/**
 * Servlet implementation class Registrationservlet
 */
@WebServlet("/Registrationservlet")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrationservlet() {
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
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address1=request.getParameter("address1");
		String address2=request.getParameter("address2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zip=request.getParameter("zip");
		Registration rs=new Registration();
		rs.setFirstname(firstname);
		rs.setLastname(lastname);
		rs.setEmail(email);
		rs.setPassword(password);
		rs.setAddress(address1);
		rs.setAddress2(address2);
		rs.setCity(city);
		rs.setState(state);
		rs.setZip(zip);
		RegistrationDao rd=new RegistrationDao();
		String result=rd.registerUser(rs);
		if(result.equals("success"))
		{
			request.getRequestDispatcher("Homepage.html").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("error.html").forward(request, response);
		}
	}

}
