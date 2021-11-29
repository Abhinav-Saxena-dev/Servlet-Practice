package com.java;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ManageLogin")
public class ManageLogin extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		DataHandler data = new DataHandler();
		data.setUsername(uname);
		data.setPassword(pass);

		PrintWriter out = response.getWriter();

		DataHandler returnData = Executor.check(data);

		String uname2 = returnData.getUsername();
		String pass2 = returnData.getPassword();

		if (!(uname2.equals(""))) {
			out.print("<p> User name is : " + uname2 + "</p>");
			out.print("<p>password is : " + pass2 + "</p>");
		} else {
			out.print("<p>Make an account buddy!!</p>");
		}
	}

}
