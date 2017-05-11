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
import xmu.mystore.goodsmgt.model.Brand;
import xmu.mystore.goodsmgt.service.BrandService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class BrandTest {

	@Autowired
	private BrandService brandService;
	@Test
	public void test()
	{
		List<Brand> brandList=this.brandService.getBrandList();
		for(int i=0;i<brandList.size();i++)
			System.out.println(brandList.get(i).getName());
	}
}
