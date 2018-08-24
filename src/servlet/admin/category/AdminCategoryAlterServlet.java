package servlet.admin.category;

import entity.Category;
import service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiaozhi on 2017/6/20.
 * 修改栏目的servlet
 */
@WebServlet(name = "AdminCategoryAlterServlet", urlPatterns = "/admin/category/alter")
public class AdminCategoryAlterServlet extends HttpServlet {
    CategoryService cs = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    String categoryName = request.getParameter("categoryName");
        try {
            if(id!=null&&!"".equals(id)&&categoryName.trim()!=null&&!"".equals(categoryName.trim())) {
                cs.update(id,categoryName);
            }
            request.getRequestDispatcher("/admin/category").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("alterFailure","修改失败！");
            request.getRequestDispatcher("/admin/category").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Category category = new Category();
        try {
            if (id != null && !"".equals(id)) {
                category = cs.queryById(id);
            }
            request.setAttribute("category",category);
            request.getRequestDispatcher("../../category_update.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("operateFailure","操作失败！");
            request.getRequestDispatcher("/admin/category").forward(request,response);
        }
    }

}

