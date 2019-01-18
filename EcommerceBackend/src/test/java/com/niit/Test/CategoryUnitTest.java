package com.niit.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackend.dao.CategoryDao;
import com.niit.EcommerceBackend.model.Category;


public class CategoryUnitTest {
	
	static CategoryDao categoryDao;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}
	@Ignore
	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCategoryName("T-Shirt");
		category.setCategoryDesc("Round Neck T-Shirt of all Variety");
		boolean res = categoryDao.addCategory(category);
		assertEquals("problem in inserting  the data", true, res);
	}
	@Ignore
	@Test
	public void updateCategory() {
		Category category = categoryDao.getCategorybyCategoryName(85);
		category.setCategoryName("Jeans");
		categoryDao.updateCategory(category);
		assertEquals("Problem in updating category",category.getCategoryId(),85);
		
		
	}
	@Ignore
	@Test
	public void deleteCategory() {
		Category category = categoryDao.getCategorybyCategoryName(87);
		categoryDao.deleteCategory(category);
		assertEquals("Problem in deleting category",1,categoryDao.listCategories().size());
		
	}
	@Test
	public void showCategories() {
		Category category = new Category();
		List<Category> li = categoryDao.listCategories();
		assertEquals("problem in getting list ", 1, li.size());
		for(Category c : li) {
			System.out.println(c.getCategoryDesc()+" "+c.getCategoryId()+" "+c.getCategoryName());
		}
	}
	
}
