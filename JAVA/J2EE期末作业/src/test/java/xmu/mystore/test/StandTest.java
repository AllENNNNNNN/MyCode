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
import xmu.mystore.goodsmgt.model.Stand;
import xmu.mystore.goodsmgt.service.StandService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class StandTest {
	@Autowired
	private StandService standService;
	
	@Test
	public void test()
	{
		List<Stand> StandList=this.standService.getStandList();
		for(int i=0;i<StandList.size();i++)
			System.out.println(StandList.get(i).getOff_market_time());
	}

}
