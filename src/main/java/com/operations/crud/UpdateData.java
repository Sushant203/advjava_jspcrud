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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.java.DbConnect;
import com.crud.java.UserData;

public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		List<UserData> list = new ArrayList<UserData>();
		UserData s = new UserData();

		Connection conn = DbConnect.getConnection();
		String query = "select * from userdata where id=?";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				s.setId(rs.getString("id"));
				s.setName(rs.getString("name"));
				s.setAge(rs.getString("age"));
				s.setAddress(rs.getString("address"));
				
				list.add(s);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	request.setAttribute("userList", list);
	RequestDispatcher rd = request.getRequestDispatcher("UpdateData.jsp");
	rd.forward(request, response);

		}

}
