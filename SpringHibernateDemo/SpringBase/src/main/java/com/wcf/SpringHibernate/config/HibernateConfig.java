package com.wcf.SpringHibernate.config;

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
	private String jdbcURL="jdbc:mysql://www.chongfer.cn:3306/mw2017";
	private String username="root";
	private String password="";
	@Bean
	public SessionFactory sessionFactory()
	{
		try
		{
			LocalSessionFactoryBean lsfb=new LocalSessionFactoryBean();
			lsfb.setDataSource(dataSource());
			lsfb.setPackagesToScan(new String[]{"com.wcf.SpringHibernate.domain","com.wcf.SpringHibernate.dao"});
			Properties props=new Properties();
			//设置方言，采用的是mysql
			props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
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
