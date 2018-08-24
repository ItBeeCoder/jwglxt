package servlet.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CategoryService;

/**
 * 添加栏目Servlet
 */
@WebServlet(name = "AdminCategoryAddServlet",urlPatterns = "/admin/category/add")
public class AdminCategoryAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CategoryService catSer = new CategoryService();   

    public AdminCategoryAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("../../category_new.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String categoryName = request.getParameter("categoryName");
		try {
			catSer.add(id, categoryName);
			request.getRequestDispatcher("/admin/category").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("/addCategoryFailure","添加栏目失败！" );
	    	request.getRequestDispatcher("/admin/category/add").forward(request,response);
		}
	}

}
