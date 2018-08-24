package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import util.connection.DataConn;



public class CategoryDao {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	DataConn dc = null;
	//增加栏目
	public void add(Category category) throws Exception{
		conn = dc.getConnection();
	    String sql = "insert into cms_category(id,category_name) values('"+ category.getId() +"','"+ category.getCategoryName() +"')"; 
	    stmt = conn.createStatement();
	    int result= stmt.executeUpdate(sql);
		dc.release(conn);
	}
	
    //根据id删除栏目
	public void del(String id) throws Exception{
		conn = dc.getConnection();
	    String sql = "delete from cms_category where id ='"+id+"'";
	    stmt = conn.createStatement();
	    int result = stmt.executeUpdate(sql);
		dc.release(conn);
	}
	
	//列出所有的栏目
	public List<Category> listAll() throws Exception{
		conn = dc.getConnection();
	    String sql = "select id,category_name from cms_category";
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(sql);
	    List<Category> categoryList = new ArrayList<Category>();
	    while(rs.next()){
	    	Category category = new Category();
	    	category.setId(rs.getString(1));
	    	category.setCategoryName(rs.getString(2));
	    	categoryList.add(category);
	    }
		dc.release(conn);
	   
		return categoryList;
	}
	
	//更新栏目
	public void update(Category category) throws Exception{
		conn = dc.getConnection();
		String sql = "update cms_category as cc set cc.category_name = '"+category.getCategoryName()+"'where cc.id ='"+category.getId()+"'";
		stmt = conn.createStatement();
	    int result = stmt.executeUpdate(sql);
		dc.release(conn);
	}
    
	
	//根据id查询栏目名称
	public String queryCategoryNameById(String id) throws Exception{
		conn = dc.getConnection();
	    String sql = "select category_name from cms_category where id ='"+id+"'";
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(sql);
	    String categoryName = null;
	    while(rs.next()){
	    	categoryName = rs.getString(1);
	    }
	    dc.release(conn);
		return categoryName;
	}

	//根据id查询栏目
	public Category queryById(String id) throws Exception{
		conn = dc.getConnection();
		String sql = "select id,category_name from cms_category where id ='"+id+"'";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		Category category = new Category();

		while(rs.next()){
//			System.out.println("数据库里的栏目id"+rs.getString(1));
			category.setId(rs.getString(1));
			category.setCategoryName(rs.getString(2));
		}
		dc.release(conn);
		return category;
	}
    
}
