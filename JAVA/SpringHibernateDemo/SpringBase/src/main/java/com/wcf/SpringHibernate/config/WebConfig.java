package com.wcf.SpringHibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//启用Mvc
@EnableWebMvc
//启用组件扫描
@ComponentScan("com.wcf.SpringHibernate")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	//配置JSP视图解析器
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	//配置静态资源的处理
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
	/*
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBean sfb=new LocalSessionFactoryBean();
		sfb.setDataSource(datasource);
		sfb.setPackagesToScan(new String[]{"com.wcf.SpringHibernate.domain"});
		Properties props=new Properties();
		props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
		sfb.setHibernateProperties(props);
		return sfb;
	}
	*/

	

}