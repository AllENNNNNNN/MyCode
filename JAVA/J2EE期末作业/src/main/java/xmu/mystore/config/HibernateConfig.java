package xmu.mystore.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
@Configuration


public class HibernateConfig {
	private String driverClassName="com.mysql.jdbc.Driver";
	private String jdbcURL="jdbc:mysql://www.chongfer.cn:3306/j2ee";
	private String username="root";
	private String password="a280298";
	@Bean
	public SessionFactory sessionFactory()
	{
		try
		{
			LocalSessionFactoryBean lsfb=new LocalSessionFactoryBean();
			lsfb.setDataSource(dataSource());
			lsfb.setPackagesToScan(new String[]{"xmu.mystore.goodsmgt.model"});
			Properties props=new Properties();
			//ÉèÖÃ·½ÑÔ£¬²ÉÓÃµÄÊÇmysql
			props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			props.setProperty("hibernate.show_sql", "true");
			lsfb.setHibernateProperties(props);
			lsfb.afterPropertiesSet();
			SessionFactory object=lsfb.getObject();
			return object;
			
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
			return null;
		}
	}
	
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(this.jdbcURL);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	
}