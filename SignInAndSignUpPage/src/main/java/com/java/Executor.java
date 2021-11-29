package com.java;

import java.sql.*;

public class Executor {

	public static Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myData", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static DataHandler check(DataHandler data) {
		String uname = data.getUsername();
		String pass = data.getPassword();
		int status = 0;
		data.setUsername("");
		data.setPassword("");
		try {
			Connection con = Executor.getConnection();
			PreparedStatement stmt = con
					.prepareStatement("select username,password from loginDetails where username=?&&password=?");
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				data.setUsername(rs.getString(1));
				data.setPassword(rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static int insert(DataHandler data) {
		String uname = data.getUsername();
		String pass = data.getPassword();
		int status = 0;
		try {
			Connection con = Executor.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into loginDetails(username,password) values(?,?)");
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			status = stmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
