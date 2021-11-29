package com.java;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("sname");
		String pass = request.getParameter("spass");
		
		DataHandler data = new DataHandler();
		data.setUsername(uname);
		data.setPassword(pass);
		
		int status = Executor.insert(data);
		PrintWriter out = response.getWriter();
		
		if(status > 0) {
			out.print("<p>Successfully created your account</p>");
		}
		else {
			out.print("<p>Failed to create your account</p>");
		}
	}

}
