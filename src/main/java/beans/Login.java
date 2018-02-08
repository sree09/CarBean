package beans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		DbConnection db = new DbConnection();
		HttpSession session = request.getSession(true);
		LoginBean user = (LoginBean)session.getAttribute("ud");
		boolean isValid = db.validateUser(user.getUserName(), user.getPassword());

		if(isValid)
		{
			response.sendRedirect("success.jsp");
		}
		else
		{
			response.sendRedirect("Login.jsp");
		}

	}
}

