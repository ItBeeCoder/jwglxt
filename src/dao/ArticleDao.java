package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Article;
import util.connection.DataConn;



public class ArticleDao {

	static Connection conn = null;
	static Statement stmt = null;
	ResultSet rs =null;
	static DataConn dc = null;

	//增加文章
	public static void add(Article art) throws Exception{
		conn = dc.getConnection();
	    String sql = "insert into cms_article(id,category_id,title,digest,author,date) values('"+ art.getId() +"','"+ art.getCategoryId()
	    +"','"+art.getTitle()+"','"+art.getDigest()+"','"+art.getAuthor()+"','"+art.getDate()+"')"; 
	    stmt = conn.createStatement();
	    int result = stmt.executeUpdate(sql);
		dc.release(conn);
	}
	
    //删除文章
	public void del(String id) throws Exception{
		conn = dc.getConnection();
	    String sql = "delete from cms_article where id ='"+id+"'";
	    stmt = conn.createStatement();
	    int result = stmt.executeUpdate(sql);
		dc.release(conn);
	}

	
	//根据所属栏目查询文章
	public List<Article> queryByCat(String categoryId) throws Exception{
		    conn = dc.getConnection();
		    String sql = "select * from cms_article where category_id = '"+categoryId+"'";
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(sql);
		    List<Article> articleList = new ArrayList<Article>();
		    while(rs.next()){
		    	Article article = new Article();
		    	article.setId(rs.getString(1));
		    	article.setCategoryId(rs.getString(2));
		    	article.setTitle(rs.getString(3));
		    	article.setDigest(rs.getString(4));
		    	article.setAuthor(rs.getString(5));
		    	article.setDate(rs.getDate(6));
		    	articleList.add(article);
		    }
		dc.release(conn);
		   
			return articleList;
		}
	
	//根据id查询文章
	public Article queryById(String id) throws Exception{
		conn = dc.getConnection();
	    String sql = "select * from cms_article where id = '"+id+"'";
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(sql);
	    Article article = new Article();
	    while(rs.next()){
	    	article.setId(rs.getString(1));
	    	article.setCategoryId(rs.getString(2));
	    	article.setTitle(rs.getString(3));
	    	article.setDigest(rs.getString(4));
	    	article.setAuthor(rs.getString(5));
	    	article.setDate(rs.getDate(6));
	    }
		dc.release(conn);
	   
		return article;
	}

	//更新文章
	public void update(Article art) throws Exception{
		conn = dc.getConnection();
		String sql = "update cms_article as ca set ca.category_id = '"+art.getCategoryId()+
				"',ca.title ='"+art.getTitle()+"',ca.digest = '"+art.getDigest()+"',ca.author='"+art.getAuthor()+"',ca.date='"+art.getDate()+"'where ca.id ='"+art.getId()+"'";
		System.out.println("更新文章的sql语句为："+sql);
		stmt = conn.createStatement();
	    int result = stmt.executeUpdate(sql);
	    dc.release(conn);
	}
    
    
}
