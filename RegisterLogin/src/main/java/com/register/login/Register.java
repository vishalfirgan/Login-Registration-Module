package com.register.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registerUrl")
public class Register extends HttpServlet {

	String url = "jdbc:mysql://localhost:3306/myjdbcdb2";
	String username = "root";
	String dbpass = "root";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name1");
		String email = req.getParameter("email1");
		String pass = req.getParameter("pass1");
		String gender = req.getParameter("gender1");
		String city = req.getParameter("city1");

//		System.out.println(name + email);
		PrintWriter out = resp.getWriter();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, username, dbpass);

			String query = "insert into register values (?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setString(4, gender);
			ps.setString(5, city);

			int cnt = ps.executeUpdate();

			if (cnt > 0) {
				System.out.println(cnt);
				resp.setContentType("text/html");

				HttpSession session = req.getSession();
				
				session.setAttribute("session_name", name);
				//				out.println("<h3 style='color:green'>Registered Successfully ! Welcome "+name+" : )</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			

				rd.include(req, resp);
			} else {

				resp.setContentType("text/html");

				out.println("<h3 style='color:red'>User not Registered. Try Again</h3>");

				RequestDispatcher rd = req.getRequestDispatcher("/form.jsp");

				rd.include(req, resp);

			}

		} catch (Exception e) {

			e.printStackTrace();

			resp.setContentType("text/html");

			out.println("<h3 style='color:red'>Exception  occured : " + e.getMessage() + "</h3>");

			RequestDispatcher rd = req.getRequestDispatcher("/form.jsp");

			rd.include(req, resp);
		}

	}

}
