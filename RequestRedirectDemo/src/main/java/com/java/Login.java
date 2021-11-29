package com.java;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet1")
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");  
		
		String uname = req.getParameter("userName");
		String pass = req.getParameter("userPass");
		
		PrintWriter out = res.getWriter();
		
		if(pass.equals("servlet")){
			RequestDispatcher rd = req.getRequestDispatcher("servlet2");
			rd.forward(req, res);
		} 
		else {
			out.print("Wrong username or password");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, res);  // basically means same page par show kardega target url ke source ko.
		}
	}
}
