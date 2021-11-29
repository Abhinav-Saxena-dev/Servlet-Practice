import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class Executor {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myData?useSSL=false","root","root");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static int insert(DataHandler data) {
		String uname = data.getUname();
		String pass = data.getPass();
		
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into details(uname, pass) values(?,?)");
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			status = stmt.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
