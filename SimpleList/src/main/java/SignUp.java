

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		String cpass = req.getParameter("cpass");
		
		RequestDispatcher rd;
		
		PrintWriter out = res.getWriter();
		if(!(pass.equals(cpass))) {
			rd = req.getRequestDispatcher("/SignUp");
			out.print("<h1>The password don't match, be careful and try again</h1>");
		}
		else{
			DataHandler data = new DataHandler();
			data.setUname(uname);
			data.setPass(pass);
			int status = Executor.insert(data);
			if(status > 0) {
			rd = req.getRequestDispatcher("/NewFile.html");
			out.print("<h1> Successfully Signed up </h1>");
			rd.forward(req, res);
			}
			else {
				rd = req.getRequestDispatcher("/SignUp");
				rd.include(req, res);
				out.print("<h1>Some problem occured, Try again and if the problem persists contact the authority</h1>");
			}
		}
		out.close();
	}

}
