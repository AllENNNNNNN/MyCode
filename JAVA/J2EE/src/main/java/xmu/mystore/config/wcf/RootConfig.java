package xmu.mystore.config.wcf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.FilterType;

/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:41:49
*/
@Configuration

@ImportResource("classpath:xmu/mystore/config/wcf/mybatis-config.xml")
@ComponentScan(basePackages={"xmu.mystore"},excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {

	RootConfig()
	{
		System.out.println("RootConfig初始化!");
	}
}