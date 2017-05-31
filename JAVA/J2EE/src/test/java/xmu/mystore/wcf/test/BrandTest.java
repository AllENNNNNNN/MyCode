package xmu.mystore.wcf.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import xmu.mystore.config.wcf.RootConfig;
import xmu.mystore.config.wcf.WebConfig;
import xmu.mystore.goodsmgt.wcf.mapper.BrandMapper;
import xmu.mystore.goodsmgt.wcf.model.Brand;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:45:49
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class BrandTest {


	@Autowired
	private BrandMapper brandMapper;
	@Test
	public void getBrandList()
	{
		System.out.println("_______getBrandList______");
		for(int i=0;i<this.brandMapper.getBrandList().size();i++)
		{
			System.out.println(this.brandMapper.getBrandList().get(i).getName());
		}
		System.out.println("_______getBrandList______");
	}
	
	@Test
	public void getBrandById()
	{
		System.out.println("_______getBrandById______");
		System.out.println(this.brandMapper.getBrandById(1).getDescription());
		
		System.out.println("_______getBrandById______");
		
	}
	/*
	@Test
	public void addBrand()
	{
		System.out.println("_______addBrand______");
		Brand brand=new Brand("唐家龙","www.baidu.com","好",1);
		this.brandMapper.addBrand(brand);
		
		
		System.out.println("_______addBrand______");
		
	}
	
	*/
	@Test
	public void deleteBrandById()
	{
		System.out.println("_______deleteBrandById______");
		
		this.brandMapper.deleteBrandById(7);
		System.out.println("_______deleteBrandById______");
		
	}
	
	@Test
	public void updateBrand()
	{
		System.out.println("_______updateBrand______");
		
		Brand brand=this.brandMapper.getBrandById(8);
		brand.setName("亚强");
		this.brandMapper.updateBrand(brand);
		System.out.println("_______updateBrand______");
		
	}
	
}
