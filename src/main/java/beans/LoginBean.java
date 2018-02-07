package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

public class LoginBean {
	String userName="";
	String password="";
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
	/*
	public boolean valid() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "cars";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root"; 
		String pass = "root";
		String username="";
		String userpass="";
		String strQuery= ""; 
		Statement st=null;
		ResultSet rs=null;
		boolean res = false;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url+dbName,user,pass);
			if(userName!=null &&userName!=""&& password!=null &&password!="")
			{
				username = userName;
				userpass = password;
				strQuery="select * from users where user_name='"+username+"' and  password='"+userpass+"'";
				System.out.println(strQuery);
				st = conn.createStatement();
				rs = st.executeQuery(strQuery);
				int count =0;
				while(rs.next())
				{

					count++;
				}
				if(count>0)
				{
					res = true;
				}
				else
					res = false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}*/
