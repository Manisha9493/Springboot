package com.mycompany.conference;

import java.util.Locale;

import org.aopalliance.intercept.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//@ComponentScan(basePackages = { "com.mycompany.conference"})
public class ConferenceCofig implements WebMvcConfigurer {
	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setSuffix(".jsp");
		bean.setPrefix("/WEB-INF/JSP/");
		bean.setOrder(0);
		return bean;

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/files/**").addResourceLocations("/WEB-INF/PDF/");
	}

	public void addInterceptor(InterceptorRegistry registry) {
		registry.addInterceptor(localChangeInterceptor());
	}

	@Bean
	public LocaleResolver localResolver() {
		SessionLocaleResolver localResolver = new SessionLocaleResolver();
		localResolver.setDefaultLocale(Locale.US);
		return localResolver;

	}

	public LocaleChangeInterceptor localChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;

	}

}
