package util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request1 = (HttpServletRequest) request;
		HttpServletResponse response1 = (HttpServletResponse) response;
	
		String uri = request1.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		HttpSession session = request1.getSession();
		String username  = (String) session.getAttribute("username");
		String isGuest = (String) session.getAttribute("isGuest");
		if(isGuest!=null){//游客直接访问管理员的页面
			System.out.println("URI:" + uri + ">>>>访问被拒绝！");
			response1.sendRedirect("/login");
		}
		if( username==null||"".equals(username)) {//非法用户访问管理员的页面
			System.out.println("URI:" + uri + ">>>>访问被拒绝！");
			response1.sendRedirect("/login");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
