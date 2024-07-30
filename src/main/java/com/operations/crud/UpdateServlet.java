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

import com.crud.java.DbConnect;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		
		try {
			Connection con = DbConnect.getConnection();
			String query = "update userdata set name=?,address=?,age=? where id=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			st.setString(2, address);
			st.setString(3, age);
			st.setString(4, id);
			st.executeUpdate();

			response.sendRedirect("MyServlet");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
