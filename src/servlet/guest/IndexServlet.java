package servlet.guest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Article;
import entity.Category;
import service.ArticleService;
import service.CategoryService;


/**
 * 首页servlet
 */
@WebServlet(name = "IndexServlet",urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CategoryService catSer = new CategoryService();
	ArticleService artSer = new ArticleService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Category> categoryList = new ArrayList<Category>();
			List<Article> articleList = new ArrayList<Article>();
			try {
				String  guest = request.getParameter("guest");
				System.out.println("是游客："+guest);
				if(guest!=null&&"1".equals(guest)){
					HttpSession session = request.getSession();
					session.setAttribute("isGuest","游客");
					System.out.println("创建session");
				}
				categoryList = catSer.listAll();
			    String categoryId = request.getParameter("categoryId");
			    if(categoryId!=null&&!"".equals(categoryId)){
				   articleList = artSer.queryByCat(categoryId);
			    }else{//刚进入index.jsp默认展示第一个栏目的文章
				articleList = artSer.queryByCat("1");
			    }
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("articleList", articleList);
			request.getRequestDispatcher("index.jsp").forward(request,response);
			
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
