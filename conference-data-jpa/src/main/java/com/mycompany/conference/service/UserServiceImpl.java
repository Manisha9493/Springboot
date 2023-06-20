package com.mycompany.conference.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.conference.model.User;
import com.mycompany.conference.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	@Transactional
	public User save(User user) {
	
		return userRepository.save(user);
	}

}
