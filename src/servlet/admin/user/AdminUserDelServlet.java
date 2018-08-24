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
@WebServlet(name = "AdminUserDelServlet", urlPatterns = "/admin/user/del")
public class AdminUserDelServlet extends HttpServlet {
    UserService us = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            if (id > 0) {
                us.del(id);
            request.getRequestDispatcher("/admin/user").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("delUserFailure","删除用户失败！");
            request.getRequestDispatcher("/admin/user").forward(request,response);
        }

    }
}
