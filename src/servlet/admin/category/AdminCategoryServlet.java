package servlet.admin.category;

import entity.Category;
import service.CategoryService;

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
 * 进入栏目管理的servlet
 */
@WebServlet(name = "AdminCategoryServlet",urlPatterns = "/admin/category")
public class AdminCategoryServlet extends HttpServlet {
    CategoryService cs = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = new ArrayList<Category>();
        try {
            categoryList = cs.listAll();
            request.setAttribute("categoryList",categoryList);
            request.getRequestDispatcher("../admin_category.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
