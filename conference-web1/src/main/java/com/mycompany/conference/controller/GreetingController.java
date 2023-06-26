package com.mycompany.conference.controller;

import java.util.Map;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class GreetingController {
	
	@GetMapping("greeting")
	public String greeting(Map <String,Object> model)
	{   model.put("message", "Hello Team!");
		return "greeting";
		
	}
	
	


}
