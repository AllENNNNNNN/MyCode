package xum.mystore.goodsmgt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xmu.mystore.goodsmgt.model.Brand;
import xmu.mystore.goodsmgt.model.Category;
import xmu.mystore.goodsmgt.model.Goods;
import xmu.mystore.goodsmgt.service.BrandService;
import xmu.mystore.goodsmgt.service.CategoryService;
import xmu.mystore.goodsmgt.service.GoodsService;

@Controller
@RequestMapping(value="GoodsManage/")
public class GoodsManageController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	@RequestMapping(value="showList",method=RequestMethod.GET)
	public String showList(Model model)
	{

		List<Goods> goodsList=this.goodsService.getGoodsList();
		model.addAttribute("goodsList", goodsList);
		return "goodsList";
	}

	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(Model model)
	{

		List<Category> CategoryList=this.categoryService.getCategoryList();
		List<Brand> brandList=this.brandService.getBrandList();
		model.addAttribute("CategoryList", CategoryList);
		model.addAttribute("brandList", brandList);
		return "addGoods";
	}
	
	@RequestMapping(value="added",method=RequestMethod.POST)
	public String added(Goods goods,Model model)
	{

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		goods.setAdd_time(df.format(new Date()));
		goods.setLast_modified_time(df.format(new Date()));
		goods.setRedeem_point(goods.getMarket_price().intValue());
		goods.setPre_sal_number(goods.getStock_count());
		this.goodsService.addGoods(goods);
		model.addAttribute("goodsList", this.goodsService.getGoodsList());
		return "goodsList";
	}
	
	@RequestMapping(value="delete")
	public String delete(@RequestParam(value="id") int id,Model model)
	{

		this.goodsService.deleteGoodsById(id);
		model.addAttribute("goodsList", this.goodsService.getGoodsList());
		return "goodsList";
	}
	
	@RequestMapping(value="modify")
	public String modify(@RequestParam(value="id") int id,Model model)
	{
		Goods goods=this.goodsService.getGoodsById(id);
		List<Category> CategoryList=this.categoryService.getCategoryList();
		List<Brand> brandList=this.brandService.getBrandList();
		model.addAttribute("CategoryList", CategoryList);
		model.addAttribute("brandList", brandList);
		model.addAttribute("goods", goods);
		return "modifyGoods";
	}
	
	@RequestMapping(value="modifyed")
	public String modifyed(Goods goods,Model model)
	{
		
		this.goodsService.updateGoods(goods);
		model.addAttribute("goodsList", this.goodsService.getGoodsList());
		return "goodsList";
	}
	

}
