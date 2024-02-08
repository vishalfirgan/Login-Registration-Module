package com.register.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.catalina.connector.Response;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginurl")
public class Login extends HttpServlet {

	String url = "jdbc:mysql://localhost:3306/myjdbcdb2";
	String username = "root";
	String dbpass = "root";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();
		String eEmail = req.getParameter("email2");
		String ePass = req.getParameter("pass2");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, username, dbpass);

			String query = "select * from register where email=? AND password=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, eEmail);
			ps.setString(2, ePass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				HttpSession session = req.getSession();
				session.setAttribute("session_name", rs.getString("name"));

				RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");

				rd.include(req, res);

			} else {

				out.println("<h3 style='color:red'>Email and Password did't match</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/form.jsp");

				rd.include(req, res);

			}

		} catch (Exception e) {

			out.println("<h3 style='color:red'>Some error occured</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/form.jsp");

			rd.include(req, res);

			e.printStackTrace();
		}
	}

}
