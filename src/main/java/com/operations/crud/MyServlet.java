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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.crud.java.*;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String id = request.getParameter("id");
	        String name = request.getParameter("name");
	        String address = request.getParameter("address");
	        String age = request.getParameter("age");
	        String query = "INSERT INTO userdata(id, name,age, address) VALUES(?, ?, ?, ?)";
	        try (Connection conn = DbConnect.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {
	            stmt.setString(1, id);
	            stmt.setString(2, name);
	            stmt.setString(4, age);
	            stmt.setString(3, address);
	            
	            int res = stmt.executeUpdate();
	            if (res > 0) {
	                response.sendRedirect("MyServlet");
	            } else {
	                response.getWriter().println("Cannot post data");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("Error: " + e.getMessage());
	        }
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        List<UserData> list = new ArrayList<UserData>();
	        String query = "SELECT * FROM userdata";
	        try (Connection conn = DbConnect.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {
	            while (rs.next()) {
	                String id = rs.getString("id");
	                String name = rs.getString("name");
	                String age = rs.getString("age");
	                String address = rs.getString("address");
	                
	                UserData userdata = new UserData();
	                userdata.setId(id);
	                userdata.setName(name);
	                userdata.setAge(age);
	                userdata.setAddress(address);
	                
	                list.add(userdata);
	            }
	            request.setAttribute("userList", list);
	            
	            RequestDispatcher rd = request.getRequestDispatcher("getData.jsp");
	            rd.forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("Error: " + e.getMessage());
	        }
	    }
}
