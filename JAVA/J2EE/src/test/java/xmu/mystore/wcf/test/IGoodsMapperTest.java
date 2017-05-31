package xmu.mystore.wcf.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import xmu.mystore.config.wcf.RootConfig;
import xmu.mystore.config.wcf.WebConfig;
import xmu.mystore.goodsmgt.wcf.model.Goods;
import xmu.mystore.goodsmgt.wcf.service.outter.IGoodsMapper;
import xmu.mystore.goodsmgt.wcf.service.outter.SelectParameters;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:46:02
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class IGoodsMapperTest {
	
	
	
	@Autowired
	private IGoodsMapper iGoodsMapper;
	@Autowired 
	private HttpServletRequest request;  
	@Test
	public void getGoodsByGoodsCode()
	{
		this.iGoodsMapper.getGoodsByGoodsCode("EXF34324");
	}
	
	@Test
	public void getBrandList()
	{
		this.iGoodsMapper.getBrandList();
	}
	
	@Test
	public void getCategoryList()
	{
		this.iGoodsMapper.getCategoryList();
	}
	
	@Test
	public void getGoodsPrice()
	{
		this.iGoodsMapper.getGoodsPrice((long) 6);
	}
	
	@Test
	public void getGoodsByGoodsName()
	{
		this.iGoodsMapper.getGoodsByGoodsName("香烟");
	}
	/*
	@Test
	public void getPath()
	{
		System.out.println(this.request.getServletContext().getRealPath(""));
	}
	*/
	
	//
	@Test
	public void getGoodsBy()
	{
		System.out.println("按照名字的模糊匹配");
		SelectParameters selectParameters=new SelectParameters();
		selectParameters.setNo("1");
		selectParameters.setSize("10");
		selectParameters.setGoodsName("");
		List<Goods> goodsList=this.iGoodsMapper.getGoodsBy(selectParameters);
		for(Goods goods:goodsList)
			System.out.println(goods.getName());
		
		
		System.out.println("按照价格升序");
		selectParameters.setRealPrice("1");
		List<Goods> goodsList1=this.iGoodsMapper.getGoodsBy(selectParameters);
		for(Goods goods:goodsList1)
			System.out.println(goods.getName());
		
		System.out.println("按照销量升序");
		selectParameters.setRealPrice(null);
		selectParameters.setPreSaleNumber("1");
		List<Goods> goodsList2=this.iGoodsMapper.getGoodsBy(selectParameters);
		for(Goods goods:goodsList2)
			System.out.println(goods.getName());
		
		System.out.println("品牌所有商品");
		selectParameters.setPreSaleNumber(null);
		selectParameters.setBrandId("1");
		List<Goods> goodsList3=this.iGoodsMapper.getGoodsBy(selectParameters);
		for(Goods goods:goodsList3)
			System.out.println(goods.getName());
		
		System.out.println("按照品类");
		selectParameters.setBrandId(null);
		selectParameters.setCategoryId("1");
		List<Goods> goodsList4=this.iGoodsMapper.getGoodsBy(selectParameters);
		for(Goods goods:goodsList4)
			System.out.println(goods.getName());
		
	}
	
	@Test
	public void deleteGoodsNumById()
	{
		
	this.iGoodsMapper.deleteGoodsNumById("10", 1);
	}

}
