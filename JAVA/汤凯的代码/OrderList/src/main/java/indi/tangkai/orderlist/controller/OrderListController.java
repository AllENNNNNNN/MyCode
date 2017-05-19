package indi.tangkai.orderlist.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import indi.tangkai.orderlist.data.entity.Order;
import indi.tangkai.orderlist.data.entity.OrderGoods;
import indi.tangkai.orderlist.data.entity.SearchOrder;
import indi.tangkai.orderlist.data.entity.User;
import indi.tangkai.orderlist.service.OrderGoodsService;
import indi.tangkai.orderlist.service.OrderService;
import indi.tangkai.orderlist.service.UserService;

@Controller
@RequestMapping(value="/")
public class OrderListController {
	
	@Resource
	private OrderService orderService;
	@Resource
	private OrderGoodsService orderGoodsService;
	@Resource
	private UserService userService;
		
	@RequestMapping(method=RequestMethod.GET)
	public String getOrderList(Model model)
	{
		List<Order> orders = orderService.getAllOrder();
		model.addAttribute("orderlist", orders);
		return "orderlist";
	}
	
	@RequestMapping("lookupOrder")
	public String lookupOrder(Model model, HttpServletRequest request)
	{
		long order_id = Long.parseLong(request.getParameter("order_id"));
		List<OrderGoods> goods = orderGoodsService.getAllOrdersByOrderId(order_id);
		Order order = orderService.getOrderByOrderId(order_id);
		User user = userService.getUserByUserId(order.getUser_id());
		model.addAttribute("order", order);
		model.addAttribute("goodsList",goods);
		model.addAttribute("user", user);
		return "lookupOrder";
	}
	
	
	@RequestMapping("modifyOrder")
	public String modifyOrder(Model model, HttpServletRequest request)
	{
		long order_id = Long.parseLong(request.getParameter("order_id"));
		List<OrderGoods> goods = orderGoodsService.getAllOrdersByOrderId(order_id);
		Order order = orderService.getOrderByOrderId(order_id);
		model.addAttribute("order", order);
		model.addAttribute("goodsList",goods);
		return "modifyOrder";
	}
	
	@RequestMapping("updateOrder")
    public String updateOrder(Model model,long order_id, int order_status,String remark, String expressCode, 
    		String isUrgency, String consignee, String address,String telephone){	
		Order order =new Order();
		order.setOrder_id(order_id);
		order.setConsignee(consignee);
		order.setAddress(address);
		order.setTelephone(telephone);
		order.setOrder_status(order_status);
		order.setExpressCode(expressCode);
		order.setRemark(remark);
		order.setIsUrgency(isUrgency);
		orderService.updateOrder(order);
		List<Order> orderList = orderService.getAllOrder();
	    model.addAttribute("orderlist", orderList);
	    return "orderlist";
    }
	
	@RequestMapping("searchOrder")
	public String searchOrder()
	{
		return "searchOrder";
	}
	
	@RequestMapping("searchResult")
    public String searchResult(Model model,String order_id, String before_add_time,
    		String after_add_time,int order_status,String isUrgency,String goods_name,String consignee){
		long longOrder_id=0l;
		
		if(order_id != "")
			longOrder_id=Long.parseLong(order_id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		long long_before = 0;
		
		if(before_add_time!="") {
			try{				
				long_before = sdf.parse(before_add_time).getTime()/1000;  
			}catch(Exception e){
				long_before=0;
				e.printStackTrace(); 
			}			
		}
		long long_after = 0;
		if(after_add_time!="") {
			try{
				long_after = sdf.parse(after_add_time).getTime()/100;  
			}catch(Exception e){
				long_after=0;
				e.printStackTrace(); 
			}			
		}
		
		SearchOrder searchOrder = new SearchOrder(longOrder_id,order_status,consignee,goods_name,long_before,long_after,isUrgency);
		
		List<Order> orders = orderService.searchOrder(searchOrder);
		
        model.addAttribute("orderlist", orders);
	    return "orderlist";
    }

}
