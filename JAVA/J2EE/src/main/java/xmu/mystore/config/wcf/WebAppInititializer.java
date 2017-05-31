package xmu.mystore.config.wcf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:43:07
*/
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
		return new Class<?>[] {WebConfig.class};
		
	}

	//½«DispatcherServletÓ³Éäµ½ÁË¡°/¡±
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	

}