package com.accenture;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
    	JdbcTemplate temp = context.getBean("connection", JdbcTemplate.class);
    	System.out.println("Connection object from database "+temp);
    	
    }
}
