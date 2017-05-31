package xmu.mystore.goodsmgt.wcf.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.File;  
import java.io.IOException;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import xmu.mystore.goodsmgt.wcf.model.Brand;
import xmu.mystore.goodsmgt.wcf.model.Category;
import xmu.mystore.goodsmgt.wcf.model.Goods;
import xmu.mystore.goodsmgt.wcf.service.BrandService;
import xmu.mystore.goodsmgt.wcf.service.CategoryService;
import xmu.mystore.goodsmgt.wcf.service.GoodsService;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:43:32
*/
@Controller
@RequestMapping(value="GoodsManage/")
public class GoodsManageController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	@Autowired 
	private HttpServletRequest request;  
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
	public String added(@RequestParam("file") CommonsMultipartFile  file,Goods goods,Model model)
	{
	
		
		String path=this.request.getServletContext().getRealPath("")+"/resources/images/wcf/"+file.getOriginalFilename();
		goods.setImage_path("/resources/images/wcf/"+file.getOriginalFilename());
		System.out.println(path);
		File newFile=new File(path);
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public String modifyed(@RequestParam("file") CommonsMultipartFile  file,Goods goods,Model model)
	{
		if(!file.isEmpty())
		{
			String path=this.request.getServletContext().getRealPath("")+"/resources/images/wcf/"+file.getOriginalFilename();
			goods.setImage_path("/resources/images/wcf/"+file.getOriginalFilename());
			System.out.println(path);
			File newFile=new File(path);
			try {
				file.transferTo(newFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.goodsService.updateGoods(goods);
		model.addAttribute("goodsList", this.goodsService.getGoodsList());
		return "goodsList";
	}
	

}
