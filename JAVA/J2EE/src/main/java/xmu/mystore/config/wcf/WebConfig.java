package xmu.mystore.config.wcf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:43:14
*/
@SuppressWarnings("deprecation")
@Configuration
//@Import(MybatisConfig.class)

@EnableWebMvc
@ComponentScan(basePackages={"xmu.mystore.goodsmgt.wcf.controller","xmu.mystore.goodsmgt.wcf.dao","xmu.mystore.goodsmgt.wcf.service","xmu.mystore.goodsmgt.wcf.mapper"})
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware
{
	WebConfig()
	{
		System.out.println("WebConfig初始化！");
	}
	private ApplicationContext context;

	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		this.context=context;
	}



	@Bean
	public ViewResolver viewResolver() 
	{

		VelocityViewResolver viewResolver=new VelocityViewResolver();
		viewResolver.setViewClass(VelocityToolboxView.class);
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".vm");
		viewResolver.setCache(true);
		/*	viewResolver.setDateToolAttribute("date");
		viewResolver.setNumberToolAttribute("number");*/
		viewResolver.setContentType("text/html;charset=UTF-8");
		viewResolver.setExposeSpringMacroHelpers(true);
		viewResolver.setExposeRequestAttributes(true);
		viewResolver.setRequestContextAttribute("rc");
		return viewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer()
	{
		TilesConfigurer tilesConfigurer=new TilesConfigurer();
		tilesConfigurer.setTilesInitializer(new VelocityTilesInitializer(velocityConfig()));
		return tilesConfigurer;
	}

	@Bean
	public VelocityConfigurer velocityConfig()
	{
		VelocityConfigurer velocityConfig=new VelocityConfigurer();
		velocityConfig.setResourceLoaderPath("/WEB-INF/views/wcf/");
		velocityConfig.setConfigLocation(context.getResource("/WEB-INF/velocity.properties"));
		return velocityConfig;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) 
	{
		configurer.enable();
	}

	@Bean
	public CommonsMultipartResolver multipartResolver(){

		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		return resolver;
	}
}