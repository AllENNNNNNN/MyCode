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
import xmu.mystore.goodsmgt.wcf.mapper.StandMapper;
import xmu.mystore.goodsmgt.wcf.model.Stand;



/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:46:06
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class StandTest {

	@Autowired
	private StandMapper standMapper;
	
	@Test 
	public void getStandList()
	{
		List<Stand> standList=this.standMapper.getStandList();
		for(Stand stand:standList)
			System.out.println(stand.getOff_market_time());
	}
	
	@Test
	public void getStandById()
	{
		this.standMapper.getStandById(6);
	}
	
	@Test 
	public void addStand()
	{
		Stand stand=this.standMapper.getStandById(6);
		this.standMapper.addStand(stand);
	}
	
	@Test
	public void updateStand()
	{
		Stand stand=this.standMapper.getStandById(6);
		stand.setMarket_price((double) 100);
		this.standMapper.updateStand(stand);
		
	}

}
