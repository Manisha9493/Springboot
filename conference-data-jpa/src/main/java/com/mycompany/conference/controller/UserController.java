package com.mycompany.conference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.conference.model.User;
import com.mycompany.conference.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public User getUser(@RequestParam(value = "firstname") String firstname,
			@RequestParam(value = "lastname") String lastname, @RequestParam(value = "age") int age) {
		User user = new User();

		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setAge(age);

		return user;
	}

	@PostMapping("/user")
	public User saveUser(@ModelAttribute User user) {
		System.out.println("user firstname: " + user.getFirstname());
		System.out.println("user lastName: " + user.getLastname());
		userService.save(user);
		return user;

	}

}
