package com.mycompany.conference;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class ApplicationIntailizer  implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext applicationContext=new AnnotationConfigWebApplicationContext();
		applicationContext.register(ConferenceCofig.class);
		servletContext.addListener(new ContextLoaderListener(applicationContext));
		ServletRegistration.Dynamic dispatcher=servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext));
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	   
	}

}
