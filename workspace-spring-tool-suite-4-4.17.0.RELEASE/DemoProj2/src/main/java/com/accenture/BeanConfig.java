package com.accenture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.accenture")
@PropertySource("classpath:dataSource.properties")
public class BeanConfig {
	
	@Autowired
	Environment env; //--> component class present in Spring. 
	//Interface representing the environment in which the current application is running. 
	
	private String URL="url"; //resource location
	private String USERNAME="username"; //username to database
	private String PASSWORD="password"; //password for authentication
	
	@Bean("connection")
	public JdbcTemplate getTemplateObject() throws Exception {
		
		JdbcTemplate template=null;
		DriverManagerDataSource  driver=new DriverManagerDataSource();

		driver.setUrl(env.getProperty(URL));
		driver.setUsername(env.getProperty(USERNAME));
		driver.setPassword(env.getProperty(PASSWORD));
		
		template=new JdbcTemplate(driver);
		
		return template;
	}
}
