package com.operations.crud;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crud.java.*;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
	Connection conn = DbConnect.getConnection();
	String query = "delete from userdata where id=?";
	try {
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, id);
		int res=stmt.executeUpdate();
		
		if(res>0) {
			response.sendRedirect("MyServlet");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
