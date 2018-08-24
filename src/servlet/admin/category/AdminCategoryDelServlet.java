package servlet.admin.category;

import service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiaozhi on 2017/6/20.
 */
@WebServlet(name = "AdminCategoryDelServlet",urlPatterns = "/admin/category/del")
public class AdminCategoryDelServlet extends HttpServlet {
    CategoryService cs = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
        try {
            cs.del(id);
            request.getRequestDispatcher("/admin/category").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("delCategoryFailure","删除栏目失败！");
            request.getRequestDispatcher("/admin/category").forward(request,response);
        }
    }
}
