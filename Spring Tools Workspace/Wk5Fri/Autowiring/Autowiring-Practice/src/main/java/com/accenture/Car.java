package com.accenture;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.accenture.two.Tyre;

// make this class into a configuration so that it can be retrieved by the IoC context
@Configuration 

// make it such that this configuration can scan both packages
@ComponentScan(basePackages= {"com.accenture", "com.accenture.two"})

// this class will also become a component bean
@Component("carbean")
public class Car {
	
	// add autowired so that this class knows where to find the Tyre class, since it's scanning all the packages for it
	@Autowired
	private Tyre tyre;
	
	public Car (Tyre tyre) {
		this.tyre=tyre;
	}
	
	public void info() {
		System.out.println("Tyre object "+tyre);
	}
	
}

// this file becomes like your BeanConfig.java file (basically your IoC container)