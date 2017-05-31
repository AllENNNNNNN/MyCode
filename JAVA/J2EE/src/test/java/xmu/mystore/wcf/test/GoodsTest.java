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
import xmu.mystore.goodsmgt.wcf.mapper.GoodsMapper;
import xmu.mystore.goodsmgt.wcf.model.Goods;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:45:57
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class GoodsTest {
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Test
	public void getGoodsList()
	{
		List<Goods> goodsList=this.goodsMapper.getGoodsList();
		for(Goods goods:goodsList)
			System.out.println(goods.getName());
	}
	
	@Test
	public void getGoodsById()
	{
		System.out.println("getGoodsById:"+this.goodsMapper.getGoodsById(9).getAdd_time());
	}
	/*
	@Test
	public void addGoods()
	{
		Goods good=this.goodsMapper.getGoodsById(9);
		this.goodsMapper.addGoods(good);
	}
	*/
	/*
	@Test
	public void updateGoods()
	{
		Goods good=this.goodsMapper.getGoodsById(9);
		good.setName("郑龙天");
		this.goodsMapper.updateGoods(good);
	}
  */
	@Test
	public void getGoodsByGoodsCode()
	{
		System.out.println("getGoodsByGoodsCode:"+this.goodsMapper.getGoodsByGoodsCode("EXF34324").getSerial_code());
		
	}
	
	@Test 
	public void getGoodsByGoodsName()
	{
		List<Goods> goodsList=this.goodsMapper.getGoodsByGoodsName("汤凯");
		for(Goods goods:goodsList)
			System.out.println(goods.getName());
	}
	


}
