package com.mycompany.conference.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.conference.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//User save(User user);

}