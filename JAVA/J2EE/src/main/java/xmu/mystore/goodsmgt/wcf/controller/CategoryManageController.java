package xmu.mystore.goodsmgt.wcf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xmu.mystore.goodsmgt.wcf.model.Category;
import xmu.mystore.goodsmgt.wcf.service.CategoryService;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:43:29
*/
@Controller
@RequestMapping(value="CategoryManage/")
public class CategoryManageController {
	
	@Autowired
	private CategoryService categoryService;
	@RequestMapping(value="showList",method=RequestMethod.GET)
	public String showList(Model model)
	{
		List<Category> CategoryList=this.categoryService.getCategoryList();
		model.addAttribute("CategoryList", CategoryList);
		return "categoryList";
	}
	
	@RequestMapping(value="add")
	public String add(Model model)
	{
		model.addAttribute("CategoryList", this.categoryService.getCategoryList());
		return "addCategory";
	}
	
	@RequestMapping(value="added")
	public String added(Category category,Model model)
	{
		category.setType(1);
		this.categoryService.addCategory(category);
		model.addAttribute("CategoryList", this.categoryService.getCategoryList());
		return "categoryList";
	}
	
	@RequestMapping(value="delete")
	public String delete(@RequestParam(value="id") int id,Model model)
	{
		this.categoryService.deleteCategoryById(id);
		model.addAttribute("CategoryList", this.categoryService.getCategoryList());
		return "categoryList";
	}
	
	@RequestMapping(value="modify")
	public String modify(@RequestParam(value="id") int id,Model model)
	{
		Category category=this.categoryService.getCategoryById(id);
		
		model.addAttribute("CategoryList", this.categoryService.getCategoryList());
		model.addAttribute("Category", category);
		return "modifyCategory";
	}
	
	@RequestMapping(value="modifyed")
	public String modifyed(Category category,Model model)
	{
		
		this.categoryService.updateCategory(category);
	
		model.addAttribute("CategoryList", this.categoryService.getCategoryList());
		return "categoryList";
	}
	
	

}
