package com.accenture.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.accenture"})
public class BeanConfig {
// use this beanconfig container to scan all the packages and feed to main app 
}
