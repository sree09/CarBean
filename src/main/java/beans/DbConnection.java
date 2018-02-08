package beans;


import java.util.ArrayList;
import java.sql.*;

public class DbConnection {
	Connection con;
	ArrayList<CarBean> al = new ArrayList<CarBean>();
	String strQuery= ""; 
	Statement st=null;
	ResultSet rs=null;

	public void getCon(){
		if(con==null){

			try{
				Class.forName("com.mysql.jdbc.Driver");
				con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "root");
				st = con.createStatement();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}
	public ArrayList<CarBean> returnCars() {
		try {
			getCon();
			rs = null;
			rs = st.executeQuery("select * from car");
			while(rs.next()) {
				CarBean c = new CarBean();
				c.setVin(rs.getNString(1));
				c.setMake(rs.getString("make"));
				c.setModel(rs.getString("model"));
				c.setYear(Integer.parseInt(rs.getString("year")));
				c.setMileage(Float.parseFloat(rs.getString("mileage")));
				c.setPrice(Float.parseFloat(rs.getString("price")));
				al.add(c);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	public boolean validateUser(String userName,String password) {
		
		getCon();
		int count=0;
		if(userName!=null &&
				userName!="" &&password!=null &&
				password!="")
		{
			strQuery="select * from users where user_name='"+userName+"' and  password='"+password+"'";
			//System.out.println(strQuery);
			try {
				rs = null;
				rs = st.executeQuery(strQuery);
				while(rs.next())
				{
					count++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}
