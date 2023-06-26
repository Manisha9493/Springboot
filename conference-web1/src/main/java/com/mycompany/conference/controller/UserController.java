package com.mycompany.conference.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.conference.model.User;

@RestController
public class UserController {
	@GetMapping("/getUser")
	public User getUser(@RequestParam(value = "firstName", defaultValue ="Nisha") String firstName,
			@RequestParam(value = "lastName", defaultValue ="Nisha") String lastName,
			@RequestParam(value = "age", defaultValue ="26") int age)
	{   User user=new User();
	   user.setFirstName(firstName);
	   user.setLastName(lastName);
	   user.setAge(age);
	   return user;
		
	}

	
	@PostMapping("/updateUser")
	public User updateUser(User user) {
		System.out.println("User firstName"+user.getFirstName());
		return user;
		
	}
	
	
	@PostMapping("/updateUser-xml")
	public User addUser(@RequestBody User user) {
		System.out.println("Added user successull");
		return user;
		
	}
}
