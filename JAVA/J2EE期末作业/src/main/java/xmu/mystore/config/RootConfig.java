package xmu.mystore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.FilterType;
@Configuration
@Import(HibernateConfig.class)
@ComponentScan(basePackages={"xmu.mystore"},excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {

	RootConfig()
	{
		System.out.println("RootConfig≥ı ºªØ!");
	}
}