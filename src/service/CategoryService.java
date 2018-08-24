package service;

import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import entity.Category;

public class CategoryService {
 
	//添加栏目
		public void add(String id,String categoryName) throws Exception{
			Category category = new Category();
			if(id!=null&&!"".equals(id)&&categoryName!=null&&!"".equals(categoryName)){
				category.setId(id);
				category.setCategoryName(categoryName);
			}
			CategoryDao categoryDao = new CategoryDao();
			categoryDao.add(category);
			
		}
		
		//删除栏目
		public void del(String id) throws Exception{
			CategoryDao categoryDao = new CategoryDao();
			if(id!=null&&!"".equals("id")){
				categoryDao.del(id);
			}
			
		}

		//查询全部栏目
		public List<Category> listAll() throws Exception{
			
			List<Category> categoryList = new ArrayList<Category>();
			CategoryDao categoryDao = new CategoryDao();
			
			categoryList = categoryDao.listAll();
			
			return categoryList;
		}
	 
		//更新栏目
		public void update(String id,String categoryName) throws Exception{
			Category category = new Category();
			category.setId(id);
			category.setCategoryName(categoryName);
			CategoryDao categoryDao = new CategoryDao();
			categoryDao.update(category);
			
		}

		//根据id查询栏目名称
		public String queryCategoryNameById(String id)throws Exception{
			String categoryName = null;
			if(id!=null&&!"".equals(id)){
				CategoryDao categoryDao = new CategoryDao();
				categoryName = categoryDao.queryCategoryNameById(id);
			}
			return categoryName;
		}

		//根据id查询栏目
	   public Category queryById(String id) throws Exception{
			Category category = new Category();
		   if(id!=null&&!"".equals(id)){
			   CategoryDao categoryDao = new CategoryDao();
			   category = categoryDao.queryById(id);
		   }
			return category;
	   }
}
