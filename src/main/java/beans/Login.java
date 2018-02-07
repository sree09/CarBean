package beans;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "cars";
		String driver = "com.mysql.jdbc.Driver";
		String dbuser = "root"; 
		String dbpass = "root";
		String username="";
		String userpass="";
		String strQuery= ""; 
		Statement st=null;
		ResultSet rs=null;
		HttpSession session = request.getSession(true);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url+dbName,dbuser,dbpass);
			if(request.getParameter("userName")!=null &&
					request.getParameter("userName")!="" && request.getParameter("password")!=null &&
					request.getParameter("password")!="")
			{
				username = request.getParameter("userName").toString();
				userpass = request.getParameter("password").toString();
				strQuery="select * from users where user_name='"+username+"' and  password='"+userpass+"'";
				//System.out.println(strQuery);
				st = conn.createStatement();
				rs = st.executeQuery(strQuery);
				int count=0;
				while(rs.next())
				{
					//session.setAttribute("username",rs.getString(2));
					count++;
				}
				if(count>0)
				{
					response.sendRedirect("success.jsp");
				}
				else
				{
					response.sendRedirect("Login.jsp");
				}
			}
			else
			{
				response.sendRedirect("Login.jsp");
			}
		//	System.out.println("Connected to the database"); 
			conn.close();
		//	System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

