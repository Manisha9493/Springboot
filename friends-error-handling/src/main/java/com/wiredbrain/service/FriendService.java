package com.wiredbrain.service;

import org.springframework.data.repository.CrudRepository;

import com.wiredbrain.model.Friends;

public interface FriendService extends CrudRepository<Friends, Integer>{

	Iterable<Friends> findByFirstNameAndLastName(String firstName, String lastName);
	Iterable<Friends> findByFirstName(String firstName);
	Iterable<Friends> findByLastName(String lastName);
}
