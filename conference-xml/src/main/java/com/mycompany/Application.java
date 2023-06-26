package com.mycompany;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.service.SpeakerService;
import com.mycompany.service.SpeakerServiceImpl;

public class Application {
	public static void main(String args[])
	{
	
		//SpeakerService speaker=new SpeakerServiceImpl();
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		SpeakerService speaker=context.getBean("speakerService", SpeakerService.class);
		System.out.println(speaker.findAll().get(0).getFirstName());
	}

}
