package xmu.mystore.goodsmgt.wcf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xmu.mystore.goodsmgt.wcf.model.Goods;
import xmu.mystore.goodsmgt.wcf.model.Stand;
import xmu.mystore.goodsmgt.wcf.service.GoodsService;
import xmu.mystore.goodsmgt.wcf.service.StandService;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:43:47
*/
@Controller
@RequestMapping(value="standManage/")
public class StandManageController {
	@Autowired
	private StandService standService;
	
	@Autowired
	private GoodsService goodsService;
	@RequestMapping(value="showList",method=RequestMethod.GET)
	public String showList(Model model)
	{

	
		List<Stand> standList=this.standService.getStandList();
		ArrayList<Integer> indexList=new ArrayList<Integer>();
		List<Goods> goodsList=new ArrayList<Goods>();
		for(int i=0;i<standList.size();i++)
		{
			System.out.println(standList.get(i).getGoods_id());
			System.out.println(this.goodsService.getGoodsById(standList.get(i).getGoods_id()));
			goodsList.add(this.goodsService.getGoodsById(standList.get(i).getGoods_id()));
			indexList.add(i);
		}
		model.addAttribute("standList",standList);
		model.addAttribute("indexList", indexList);
		model.addAttribute("goodsList", goodsList);
		return "standList";
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(Model model)
	{
		List<Goods> goodsList=this.goodsService.getGoodsList();
		model.addAttribute("goodsList", goodsList);
		return "addStand";
	}
	@RequestMapping(value="added")
	public String added(Stand stand,Model model)
	{
		
		this.standService.addStand(stand);
		List<Stand> standList=this.standService.getStandList();
		ArrayList<Integer> indexList=new ArrayList<Integer>();
		List<Goods> goodsList=new ArrayList<Goods>();
		
		for(int i=0;i<standList.size();i++)
		{
			System.out.println(standList.get(i).getGoods_id());
			System.out.println(this.goodsService.getGoodsById(standList.get(i).getGoods_id()));
			goodsList.add(this.goodsService.getGoodsById(standList.get(i).getGoods_id()));
			indexList.add(i);
		}
		model.addAttribute("standList",standList);
		model.addAttribute("indexList", indexList);
		model.addAttribute("goodsList", goodsList);
		return "standList";
	}
	@RequestMapping(value="delete")
	public String delete(@RequestParam(value="id") int id,Model model)
	{
		this.standService.deleteStandById(id);
		
		List<Stand> standList=this.standService.getStandList();
		ArrayList<Integer> indexList=new ArrayList<Integer>();
		List<Goods> goodsList=new ArrayList<Goods>();
		for(int i=0;i<standList.size();i++)
		{
			goodsList.add(this.goodsService.getGoodsById(standList.get(i).getGoods_id()));
			indexList.add(i);
		}
		model.addAttribute("standList",standList);
		model.addAttribute("indexList", indexList);
		model.addAttribute("goodsList", goodsList);
		return "standList";
	}

	@RequestMapping(value="modify")
	public String modify(@RequestParam(value="id") int id,Model model)
	{
		List<Goods> goodsList=this.goodsService.getGoodsList();
		Stand stand=this.standService.getStandById(id);
		model.addAttribute("stand",stand);
		model.addAttribute("goodsList", goodsList );
		return "modifyStand";
	}
	
	@RequestMapping(value="modifyed")
	public String modifyed(Stand stand,Model model)
	{
		

		this.standService.updateStand(stand);
		List<Stand> standList=this.standService.getStandList();
		ArrayList<Integer> indexList=new ArrayList<Integer>();
		List<Goods> goodsList=new ArrayList<Goods>();
		for(int i=0;i<standList.size();i++)
		{
			goodsList.add(this.goodsService.getGoodsById(standList.get(i).getGoods_id()));
			indexList.add(i);
		}
		model.addAttribute("standList",standList);
		model.addAttribute("indexList", indexList);
		model.addAttribute("goodsList", goodsList);
		return "standList";
	}

}
