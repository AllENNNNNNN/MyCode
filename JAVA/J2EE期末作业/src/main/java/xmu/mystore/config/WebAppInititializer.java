package xmu.mystore.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInititializer extends AbstractAnnotationConfigDispatcherServletInitializer {


	//
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {WebConfig.class,HibernateConfig.class};
		
	}

	//½«DispatcherServletÓ³Éäµ½ÁË¡°/¡±
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	

}