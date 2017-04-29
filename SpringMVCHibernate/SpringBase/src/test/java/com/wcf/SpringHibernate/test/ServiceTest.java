package com.wcf.SpringHibernate.test;

import org.junit.runner.RunWith;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.wcf.SpringHibernate.config.RootConfig;
import com.wcf.SpringHibernate.config.WebConfig;
import com.wcf.SpringHibernate.service.NewsService;
import com.wcf.SpringHibernate.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class ServiceTest {

  
    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;
    @Test
    public void userServiceTest(){
    
    	int id=1;
    	String s=userService.getUserNameById(id);
    	System.out.println(s);
    	
    }
    @Test
    public void NewsServiceTest()
    {
    	System.out.println(this.newsService.getNewsTitleById(1));
    }

}