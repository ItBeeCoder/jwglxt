package servlet.admin.user;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaozhi on 2017/6/20.
 */
@WebServlet(name = "AdminUserServlet",urlPatterns = "/admin/user")
public class AdminUserServlet extends HttpServlet {
    UserService us = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<User> userList = new ArrayList<User>();
        try {
            userList = us.listAll();
            request.setAttribute("userList",userList);
            request.getRequestDispatcher("../admin_user.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("wrongOperate","操作失败！");
            request.getRequestDispatcher("/admin/index").forward(request,response);
        }
    }
}
