package beans;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Car extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();
		
		DbConnection db = new DbConnection();
		Connection con = db.getCon();
		//System.out.println(con);
		try {
		Statement stmt =  con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from car");
		ArrayList<CarBean> al = new ArrayList<CarBean>();
		while(rs.next()) {
			CarBean c = new CarBean();
			c.setVin(rs.getString("vin"));
			c.setMake(rs.getString("make"));
			c.setModel(rs.getString("model"));
			c.setYear(Integer.parseInt(rs.getString("year")));
			c.setMileage(Float.parseFloat(rs.getString("mileage")));
			c.setPrice(Float.parseFloat(rs.getString("price")));
			al.add(c);
		}
		session.setAttribute("carlist",al);
		request.setAttribute("cars", al);
		request.getRequestDispatcher("cars.jsp").forward(request, response);		
		
		//((ServletRequest) session).getRequestDispatcher("cars.jsp").forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}


	}


