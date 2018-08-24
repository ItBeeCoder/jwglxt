package servlet.admin.user;

import entity.User;
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
@WebServlet(name = "AdminUserAlterServlet", urlPatterns = "/admin/user/alter")
public class AdminUserAlterServlet extends HttpServlet {

    UserService us = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String psw = request.getParameter("psw");
        String id = request.getParameter("id");
        String path=request.getContextPath();
        String path2=request.getPathInfo();
//        System.out.println("path222222222=="+path2);
//        System.out.println("pathString=="+path);
        System.out.println("username=="+username+"psw=="+psw+"id=="+id);
        try {
            if (id != null && !"".equals(id)) {
                int id1 = Integer.parseInt(id);
                us.update(id1, username, psw);
                response.sendRedirect(path+"/admin/user");  
               // request.getRequestDispatcher("../admin/user").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("alterUserFailure","修改用户失败！");
            request.getRequestDispatcher("../admin/user/alter?id="+id).forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        String idstr=request.getParameter("id");
        request.setAttribute("userid", idstr);
      //  System.out.println("idstradminuseraltersvlt=="+idstr);
        int id = Integer.parseInt(idstr);
        try {
            user = us.queryById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("../../admin_user_alter.jsp?id="+idstr).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("operateFailure", "操作失败！");
            request.getRequestDispatcher("/admin/user").forward(request, response);
        }

    }
}
