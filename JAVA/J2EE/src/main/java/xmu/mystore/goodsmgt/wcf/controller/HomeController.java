package xmu.mystore.goodsmgt.wcf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.goodsmgt.wcf.model.Brand;
import xmu.mystore.goodsmgt.wcf.service.BrandService;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:43:41
*/
@Controller
@RequestMapping(value="/")
public class HomeController {
	


	@Autowired
	private BrandService brandService;
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		System.out.println("OK");
		//System.out.println(this.brandService.getBrandList().get(0).getDescription());
		List<Brand> brandList=this.brandService.getBrandList();
		model.addAttribute("brandList",brandList);
		return "home";
	}
	
	public HomeController()
	{
		System.out.println("HomeController初始化!");
	}

}