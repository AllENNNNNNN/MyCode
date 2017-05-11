package xmu.mystore.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import xmu.mystore.config.RootConfig;
import xmu.mystore.config.WebConfig;
import xmu.mystore.goodsmgt.model.Category;
import xmu.mystore.goodsmgt.service.CategoryService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class CategoryTest {
	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void test()
	{
		List<Category> CategoryList=this.categoryService.getCategoryList();
		for(int i=0;i<CategoryList.size();i++)
			System.out.println(CategoryList.get(i).getName());
	}

}
