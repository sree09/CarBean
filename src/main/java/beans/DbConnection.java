package beans;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DbConnection {
	Connection con;
	Connection getCon(){

	try{
			Class.forName("com.mysql.jdbc.Driver");
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "root");
	} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
	}
}

