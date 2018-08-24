package servlet.admin.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ArticleService;

/**
 * 删除文章servlet
 */
@WebServlet(name = "DelArticleServlet",urlPatterns = "/admin/delArticle")
public class DelArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArticleService artSer = new ArticleService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String categoryId = request.getParameter("categoryId");//返回用参数
		try {
			artSer.delete(id);
			request.getRequestDispatcher("/admin/index?categoryId="+categoryId).forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("delArticleFailure","删除文章失败" );
			request.getRequestDispatcher("/admin/index?categoryId="+categoryId).forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
