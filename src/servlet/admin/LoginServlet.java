package servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * 鐧婚檰servlet
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/mytest/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");
		 
			String username = request.getParameter("username");
			String psw = request.getParameter("psw");
			if(username==null||"".equals("username")){
				request.setAttribute("usernameIsNull", "用户名为空");
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			}
			if(psw==null||"".equals("psw")){
				request.setAttribute("pswIsNull", "密码为空");
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			}
			if(username!=null){
				UserDao userDao = new UserDao();
				try {
					String pwdInDB =userDao.queryByName(username);
						//select(username);
						//userDao.queryByName(username);
					if(pwdInDB.equals(psw)){
						HttpSession session = request.getSession(); 
						session.setAttribute("username", username);
						request.getRequestDispatcher("/admin_index.jsp").forward(request,response);
					}else{
						request.setAttribute("pswIsWrong","用户名或密码错误");
						request.getRequestDispatcher("/login.jsp").forward(request,response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
	}

	
	public void init() throws ServletException {
		// Put your code here
	}
}
