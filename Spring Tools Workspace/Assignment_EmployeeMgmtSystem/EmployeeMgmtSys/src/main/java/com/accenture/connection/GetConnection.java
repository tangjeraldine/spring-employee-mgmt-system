package com.accenture.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:dataSource.properties")
public class GetConnection {
	@Autowired
	Environment env; //--> component class present in Spring. 
	//Interface representing the environment in which the current application is running. 
	
	private String URL="url"; //resource location
	private String NAME="name"; //username to database
	private String PASSWORD="pass"; //password for authentication

	public JdbcTemplate getTemplateObject()  {

		DriverManagerDataSource  datasource =new DriverManagerDataSource();

		datasource.setUrl(env.getProperty(URL));
		datasource.setUsername(env.getProperty(NAME));
		datasource.setPassword(env.getProperty(PASSWORD));
				
		return new JdbcTemplate(datasource);
	}
	
	public void info() {
		System.out.println("-----Connection object created-----");
	}
}
