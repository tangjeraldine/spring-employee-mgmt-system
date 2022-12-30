package com.accenture;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	// create context using the Car class (much like BeanConfig)
    	ApplicationContext context = new AnnotationConfigApplicationContext(Car.class);
    	
    	// use context to obtain the bean that you declared earlier --> carbean
    	Car car = (Car) context.getBean("carbean");
    	//Tyre constructor gets printed first because it's a singleton and got instantiated the moment context was created
    	
    	//Followed by this:
    	System.out.println("This is a car object: "+car);
    	car.info();
    }
}
