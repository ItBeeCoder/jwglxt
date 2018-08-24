package test;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by xiaozhi on 2017/6/14.
 */
public class test {

	public static void main(String args[]) throws Exception {

		// for(int i = 2;i<=10;i++){
		//
		// addArticle(i);
		// addArticleContent(i);
		// addUser(i);
		// }
		// addCategory();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2016-06-06");
		System.out.println(date);
	}

	public static void addArticle(int i) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionUrl = "jdbc:mysql://localhost:3306/db_for_test?useUnicode=true&characterEncoding=utf-8";
		Connection conn = DriverManager.getConnection(connectionUrl, "root",
				"mysql");
		Statement stmt = conn.createStatement();
		Date date = new java.sql.Date(1997);
		String sql = "insert into cms_article(id,category_id,title,digest,author,date) values('"
				+ i + "','2','数据结构','树','梁老师',date)";
		int a = stmt.executeUpdate(sql);
	}

	public static void addArticleContent(int i) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionUrl = "jdbc:mysql://localhost:3306/db_for_test?useUnicode=true&characterEncoding=utf-8";
		Connection conn = DriverManager.getConnection(connectionUrl, "root",
				"mysql");
		Statement stmt = conn.createStatement();
		String sql = "insert into cms_article_content(article_id,content) values('"
				+ i + "','老师讲过啥，我都不太记得了！')";
		int a = stmt.executeUpdate(sql);
	}
	//
	// public static void addCategory() throws Exception{
	// String
	// sql="insert into cms_category(id,category_name,parent) values('2','体育老师','2')";
	// rs=stmt.executeQuery(sql);
	// }
	//
	// public static void addUser(int i) throws Exception{
	// String
	// sql="insert into cms_user(id,name,psw) values('"+i+"','老师','123456')";
	// rs=stmt.executeQuery(sql);
	// }
}
