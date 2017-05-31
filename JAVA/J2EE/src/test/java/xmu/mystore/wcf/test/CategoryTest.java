package xmu.mystore.wcf.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import xmu.mystore.config.wcf.RootConfig;
import xmu.mystore.config.wcf.WebConfig;
import xmu.mystore.goodsmgt.wcf.mapper.CategoryMapper;
import xmu.mystore.goodsmgt.wcf.model.Category;



/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:45:53
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class CategoryTest {

	@Autowired
	private CategoryMapper categoryMapper;

	@Test
	public void getCategoryList()
	{
		System.out.println("getCategoryList");
		List<Category> categoryList=this.categoryMapper.getCategoryList();
		for(Category category:categoryList)
		{
			System.out.println(category.getName());
		}
		System.out.println("getCategoryList");
	}
	
	

	@Test
	public void getCategoryById()
	{
		System.out.println("getCategoryById");
		System.out.println(this.categoryMapper.getCategoryById(1).getName());
		System.out.println("getCategoryById");
	}
	/*
	@Test
	public void addCategory()
	{
		System.out.println("addCategory");
		Category category=this.categoryMapper.getCategoryById(1);
		if(category.getUpper_category_id()==null)
			System.out.println("null");
		else
		System.out.println(category.getUpper_category_id());
		this.categoryMapper.addCategory(category);
		System.out.println("addCategory");
	}
	*/
	@Test
	public void deleteCategory()
	{
		this.categoryMapper.deleteCategoryById(11);
	}
	
	@Test
	public void updateCategory()
	{
		Category category=this.categoryMapper.getCategoryById(6);
		category.setRank(1);
		this.categoryMapper.updateCategory(category);
		
	}

}
