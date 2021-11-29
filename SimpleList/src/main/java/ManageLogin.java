import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManageLogin")
public class ManageLogin extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) {
		
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		
	}
}
