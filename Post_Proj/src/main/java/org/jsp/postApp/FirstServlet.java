package org.jsp.postApp;

import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class FirstServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);

		// fetch ui/form data
		String sid = req.getParameter("id");
		String name = req.getParameter("nm");
		String dept = req.getParameter("dp");
		String sperc = req.getParameter("perc");

		// presentation logic

		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='cyan'>" + "<h1>Trainer name " + name + " from " + dept +" is registered successfully"+ "</h1>"
				+ "</body></html>");
		out.close();

		// persistence logic

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// 1st step
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Aadarsh@1");// 2nd step
			pstmt = con.prepareStatement("insert into btm.trainer values(?,?,?,?)");// 3rd step

			pstmt.setInt(1, Integer.parseInt(sid));
			pstmt.setString(2, name);
			pstmt.setString(3, dept);
			pstmt.setDouble(4, Double.parseDouble(sperc));
			// excute 4th step
			pstmt.executeUpdate();
			System.out.println("record inserted");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
