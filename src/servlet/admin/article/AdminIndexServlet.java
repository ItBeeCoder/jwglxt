package servlet.admin.article;

import entity.Article;
import entity.Category;
import service.ArticleService;
import service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaozhi on 2017/6/20.
 */
@WebServlet(name = "AdminIndexServlet",urlPatterns = "/admin/index")
public class AdminIndexServlet extends HttpServlet {
    CategoryService catSer = new CategoryService();
    ArticleService artSer = new ArticleService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = new ArrayList<Category>();
        List<Article> articleList = new ArrayList<Article>();
        String username = null;
        try {
            categoryList = catSer.listAll();
            String categoryId = request.getParameter("categoryId");
            if(categoryId!=null&&!"".equals(categoryId)){
                articleList = artSer.queryByCat(categoryId);
            }else {//刚进入index.jsp默认展示第一个栏目的文章
                articleList = artSer.queryByCat("1");
            }
            HttpSession session = request.getSession();
            username = (String)session.getAttribute("username");
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("username",username);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("articleList", articleList);
        request.getRequestDispatcher("/admin_index.jsp").forward(request,response);
    }
}
