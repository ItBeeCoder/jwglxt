package servlet.admin.user;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiaozhi on 2017/6/20.
 */
@WebServlet(name = "AddUserServlet",urlPatterns = "/admin/addUser")
public class AddUserServlet extends HttpServlet {

	UserService us = new UserService();
	
	public AddUserServlet () {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
	    String psw = request.getParameter("psw");
	        try {
	            us.addUser(username,psw);
	            request.getRequestDispatcher("/admin/user").forward(request,response);
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.getRequestDispatcher("/admin/addUser").forward(request,response);
	        }
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/user_new.jsp").forward(request,response);
	}

	public void init() throws ServletException {
		// Put your code here
	}
}
