package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.ArticleContent;
import util.connection.DataConn;


public class ArticleContentDao {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static DataConn dc = null;

	// 添加文章内容
	public static void add(ArticleContent artCon) throws Exception {
		conn = dc.getConnection();
		String sql = "insert into cms_article_content(article_id,content) values('"
				+ artCon.getArticleId() + "','" + artCon.getContent() + "')";
		stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		dc.release(conn);
	}

	// 根据id删除文章内容
	public static void del(String articleId) throws Exception {
		conn = dc.getConnection();
		String sql = "delete from cms_article_content where article_id ='"
				+ articleId + "'";
		stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		dc.release(conn);

	}

	// 更新文章内容
	public static void update(ArticleContent artCon) throws Exception {
		conn = dc.getConnection();
		String sql = "update cms_article_content as cac set cac.content = '"
				+ artCon.getContent() + "'where cac.article_id ='"
				+ artCon.getArticleId() + "'";
		stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		dc.release(conn);
	}

	// 根据文章id查询文章内容
	public static ArticleContent queryConByArtId(String articleId) throws Exception {
		conn = dc.getConnection();
		String sql = "select * from cms_article_content where article_id = '"
				+ articleId + "'";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		ArticleContent articleContent = new ArticleContent();
		while (rs.next()) {
			articleContent.setArticleId(rs.getString(1));
			articleContent.setContent(rs.getString(2));
		}
		dc.release(conn);
		return articleContent;
	}

}
