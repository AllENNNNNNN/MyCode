package com.wcf.SpringHibernate.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wcf.SpringHibernate.domain.News;
import com.wcf.SpringHibernate.domain.User;
import com.wcf.SpringHibernate.service.NewsService;
import com.wcf.SpringHibernate.service.UserService;

//声明一个控制器
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private NewsService newsService;
	//处理对“/”的GET请求
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("message",null);
		return "home";
	}
	//处理用户登录
	@RequestMapping("Load")
	public String Load(@RequestParam(value="username") String username,@RequestParam(value="password") String password,Model model
			,HttpServletRequest request, HttpServletResponse response)
	{
		String view;
		System.out.println(this.userService.getUserNameById(1));
		if(this.userService.hasUser(username, password))
		{
			request.getSession().setAttribute("user", this.userService.getUserByName(username));
			model.addAttribute("newsList", this.newsService.getNewsList());
			view="newsList";
		}
		else
		{
			view="home";
			model.addAttribute("message", "Username or Password is wrong,please try again!");
		}
		return view;
	}

	@RequestMapping("RegistView")
	public String Regist()
	{
		return "Regist";
	}

	@RequestMapping("Regist")
	public String addUser(User user)
	{
		user.setEnabled(1);
		System.out.println(user.getAddress()+user.getUsername());
		this.userService.savaUser(user);
		return "home";
	}

	@RequestMapping("search")
	public String search(@RequestParam(value="select") String select,@RequestParam(value="searchContent") String searchContent,Model model )
	{
		List<News> newsList=new ArrayList<News>();
		if(select.equals("userId"))
		{
			try{
				int id=Integer.parseInt(searchContent);
				newsList=this.newsService.getNewsListByUserId(id);
			}
			catch(Exception e)
			{
				System.out.println(e.toString());	
				newsList=this.newsService.getNewsListByTitle(searchContent);
			}

		}
		else
		{
			newsList=this.newsService.getNewsListByTitle(searchContent);
		}
		model.addAttribute("newsList", newsList);
		return "newsList";
	}
	@RequestMapping("publish")
	public String publish(News news,Model model,HttpServletRequest request)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		news.setPublishTime(df.format(new Date()));
		news.setUser((User) request.getSession().getAttribute("user"));
		this.newsService.addNews(news);

		model.addAttribute("newsList", this.newsService.getNewsList());
		return "newsList";
	}
	@RequestMapping("delete")
	public String delete(@RequestParam(value="id") int id,Model model)
	{
		this.newsService.deleteNewsById(id);
		model.addAttribute("newsList", this.newsService.getNewsList());
		return "newsList";
	}

	@RequestMapping("modify")
	public String modify(@RequestParam(value="id") int id,Model model)
	{

		News news=this.newsService.getNewsById(id);
		System.out.println("已经Get");
		this.newsService.deleteNewsById(id);
		model.addAttribute("news", news);
		return "modify";
	}
	@RequestMapping("modifyed")
	public String modify(News news,Model model,HttpServletRequest request)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		news.setPublishTime(df.format(new Date()));
		news.setUser((User) request.getSession().getAttribute("user"));
		this.newsService.addNews(news);

		model.addAttribute("newsList", this.newsService.getNewsList());
		return "newsList";
	}
}