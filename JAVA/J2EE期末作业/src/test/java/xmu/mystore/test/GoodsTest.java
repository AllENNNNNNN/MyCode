package xmu.mystore.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import xmu.mystore.config.RootConfig;
import xmu.mystore.config.WebConfig;
import xmu.mystore.goodsmgt.model.Goods;
import xmu.mystore.goodsmgt.service.GoodsService;
import xum.mystore.goodsmgt.controller.GoodsManageController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class GoodsTest {
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private GoodsManageController goodsManageController;
	@Test
	public void test()
	{
		List<Goods> goodsList=this.goodsService.getGoodsList();
		for(int i=0;i<goodsList.size();i++)
			System.out.println(goodsList.get(0).getName());
	}
	@Test
	public void testAddGoods() throws Exception
	{
		MockMvc mockMvc=MockMvcBuilders.standaloneSetup(this.goodsManageController).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/GoodsManage/add"));
		
	}

}
