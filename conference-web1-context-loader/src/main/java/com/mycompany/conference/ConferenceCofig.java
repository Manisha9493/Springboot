package com.mycompany.conference;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages = { "com.mycompany.conference"})
public class ConferenceCofig {
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver bean=new InternalResourceViewResolver();
		bean.setSuffix(".jsp");
		bean.setPrefix("/WEB-INF/JSP/");
		bean.setOrder(0);
		return bean;
		
	}

}
