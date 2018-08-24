package servlet.admin.article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Category;
import service.ArticleService;
import service.CategoryService;

/**
 *  添加文章servlet
 */
@WebServlet(name = "AddArticleServlet",urlPatterns="/admin/addArticle")
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArticleService artSer = new ArticleService();
	CategoryService catSer = new CategoryService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");
		 
		List<Category> categoryList = new ArrayList<Category>();
		try {
			categoryList = catSer.listAll();
			request.setAttribute("categoryList", categoryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/article_new.jsp").forward(request,response);
	
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("UTF-8");
		 String pathString=request.getContextPath();
		 String realpathString=request.getPathInfo();
		 System.out.println("pathStringaddarticlesvlt=="+pathString);
		 System.out.println("realpathStringaddarticlesvlt=="+realpathString);
		 
		 String id = request.getParameter("id");
	       String categoryId = request.getParameter("categoryId");
	       String digest = request.getParameter("digest");
	       String title = request.getParameter("title");
	       String author = request.getParameter("author");
	       String content = request.getParameter("content");
	       String date = request.getParameter("date");
	       
	       System.out.println("id=="+id);
	       System.out.println("categoryId=="+categoryId);
	       System.out.println("title=="+title);
	       System.out.println("author =="+author );
	       System.out.println("date=="+date);
	       
	       try{
	    	   artSer.add(id, categoryId, digest, title, author, content, date);
	    	   
	    	   request.getRequestDispatcher("/admin_index.jsp").forward(request,response);
	       }catch(Exception e){
	    	   e.printStackTrace();
	    	   request.setAttribute("addArticleFailure","添加文章失败！" );
	    	  // request.getRequestDispatcher("/admin/addArticle").forward(request,response);
	       }
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
