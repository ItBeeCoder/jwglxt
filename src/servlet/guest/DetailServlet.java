package servlet.guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Article;
import entity.ArticleContent;
import service.ArticleService;


/**
 * 查看文章详情servelt
 */
@WebServlet(name = "DetailServlet",urlPatterns = "/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArticleService artSer = new ArticleService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article article = new Article();
		ArticleContent artCon = new ArticleContent();
		String articleId = request.getParameter("articleId");
		if(articleId!=null&&!"".equals(articleId)){
			try {
				article = artSer.queryByArtId(articleId);
				artCon = artSer.queryConByArtId(articleId);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("operateFailure","操作失败！" );
				request.getRequestDispatcher("/index").forward(request,response);
			}
			request.setAttribute("article", article);
			request.setAttribute("artCon", artCon);
			request.getRequestDispatcher("/detail.jsp").forward(request,response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
