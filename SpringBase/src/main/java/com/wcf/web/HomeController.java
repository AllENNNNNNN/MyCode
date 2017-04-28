package com.wcf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//声明一个控制器
@Controller
@RequestMapping("/")
public class HomeController {

	//处理对“/”的GET请求
	@RequestMapping(method=RequestMethod.GET)
	public String home()
	{
	return "home";
	}
}