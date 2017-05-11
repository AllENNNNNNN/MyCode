package xum.mystore.goodsmgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xmu.mystore.goodsmgt.model.Brand;
import xmu.mystore.goodsmgt.service.BrandService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	


	@Autowired
	private BrandService brandService;
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		//System.out.println(this.brandService.getBrandList().get(0).getDescription());
		List<Brand> brandList=this.brandService.getBrandList();
		model.addAttribute("brandList",brandList);
		return "home";
	}

}