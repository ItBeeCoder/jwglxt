package service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import dao.ArticleContentDao;
import dao.ArticleDao;
import entity.Article;
import entity.ArticleContent;

public class ArticleService {

    //删除文章及内容
    public static void delete(String id) throws Exception {
        ArticleDao articleDao = new ArticleDao();
        ArticleContentDao articleContentDao = new ArticleContentDao();

        if (id != null && !"".equals("id")) {
            articleDao.del(id);
            articleContentDao.del(id);
        }

    }

    //根据文章id查询文章内容
    public static ArticleContent queryConByArtId(String articleId) throws Exception {

        ArticleContentDao articleContentDao = new ArticleContentDao();
        ArticleContent articleContent = new ArticleContent();
        if (articleId != null && !"".equals(articleId)) {
            articleContent = articleContentDao.queryConByArtId(articleId);
        }
        return articleContent;
    }

    //根据文章id查询文章
    public static Article queryByArtId(String articleId) throws Exception {

        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        if (articleId != null && !"".equals(articleId)) {
            article = articleDao.queryById(articleId);
        }
        return article;
    }

    //根据类别id查询文章
    public static List<Article> queryByCat(String categoryId) {
        ArticleDao articleDao = new ArticleDao();
        List<Article> articleList = new ArrayList<Article>();
        try {
            articleList = articleDao.queryByCat(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleList;
    }

    //新增文章及内容
    public static void add(String id, String categoryId, String digest, String title, String author, String content, String date) throws Exception {
        //转成java.sql.Date类型的日期，以便存储在数据库中
        System.out.println("前台传过来的content"+content);
        Date date1 = null;
        java.sql.Date date2 = null;
        if (date != null && !"".equals("date")) {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            date2 = new java.sql.Date(date1.getTime());
        }

        if (id != null && !"".equals("id") && categoryId != null && !"".equals("categoryId")) {
            Article article = new Article();
            article.setId(id);
            article.setCategoryId(categoryId);
            article.setDigest(digest);
            article.setTitle(title);
            article.setAuthor(author);
            article.setDate(date2);

            ArticleContent articleContent = new ArticleContent();
            articleContent.setArticleId(id);
            articleContent.setContent(content);

            ArticleDao articleDao = new ArticleDao();
            ArticleContentDao articleContentDao = new ArticleContentDao();

            articleDao.add(article);
            articleContentDao.add(articleContent);
        }


    }

    //更新文章及内容
    public static  void update(String id, String categoryId, String digest, String title, String author, String content, String date) throws Exception {
        //转成java.sql.Date类型的日期，以便存储在数据库中
        Date date1 = null;
        java.sql.Date date2 = null;
        if (date != null && !"".equals("date")) {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            date2 = new java.sql.Date(date1.getTime());
        }

        if (id != null && !"".equals("id") && categoryId != null && !"".equals("categoryId")) {
            Article article = new Article();
            article.setId(id);
            article.setCategoryId(categoryId);
            article.setDigest(digest);
            article.setTitle(title);
            article.setAuthor(author);
            article.setDate(date2);

            ArticleContent articleContent = new ArticleContent();
            articleContent.setArticleId(id);
            articleContent.setContent(content);

            ArticleDao articleDao = new ArticleDao();
            ArticleContentDao articleContentDao = new ArticleContentDao();

            articleDao.update(article);
            articleContentDao.update(articleContent);
        }

    }
}
