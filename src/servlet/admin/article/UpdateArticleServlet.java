package servlet.admin.article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Article;
import entity.ArticleContent;
import entity.Category;
import service.ArticleService;
import service.CategoryService;

/**
 * 更新文章servlet
 */
@WebServlet(name = "UpdateArticleServlet",urlPatterns = "/admin/updateArticle")
public class UpdateArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArticleService artSer = new ArticleService(); 
    CategoryService catSer = new CategoryService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
//    	request.setAttribute("articleId", request.getParameter("id"));
    	String articleId = request.getParameter("id");
    	if(articleId!=null&&!"".equals(articleId)){
    		try {
    		Article article = new Article();
        	article = artSer.queryByArtId(articleId);
        	
        	List<Category> categoryList = new ArrayList<Category>();
			categoryList = catSer.listAll();
			
        	ArticleContent articleContent = new ArticleContent();
        	articleContent = artSer.queryConByArtId(articleId);
    
    	request.setAttribute("oldArticle", article);
    	request.setAttribute("categoryList", categoryList);
    	request.setAttribute("oldArticleContent", articleContent);
    	
		request.getRequestDispatcher("/article_update.jsp").forward(request,response);
    	}catch (Exception e) {
			e.printStackTrace();
	    request.setAttribute("operateFailure", "操作失败！");
	    request.getRequestDispatcher("/admin/index").forward(request,response);
		}
	   }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String id = request.getParameter("id");
	       String categoryId = request.getParameter("categoryId");
	       String digest = request.getParameter("digest");
	       String title = request.getParameter("title");
	       String author = request.getParameter("author");
	       String content = request.getParameter("content");
	       String date = request.getParameter("date");
	       try{
	    	   artSer.update(id, categoryId, digest, title, author, content, date);
	    	   request.getRequestDispatcher("/admin/index?categoryId="+categoryId).forward(request,response);
	       }catch(Exception e){
	    	   e.printStackTrace();
	    	   request.setAttribute("updateArticleFailure","更新文章失败！" );
	    	   request.getRequestDispatcher("/admin/updateArticle?categoryId="+categoryId).forward(request,response);
	       }
	}

}
