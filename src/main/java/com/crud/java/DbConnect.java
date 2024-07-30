package com.crud.java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnect {
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3309/user_registration";
		String user = "root";
		String password="Sushii@12";
//		System.out.println("Hello");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error in sql query");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(conn!=null) {
			System.out.println("");
		}
		else {
			System.out.println("Connection in not establish");
		}
		return conn;
		
	}
	}


