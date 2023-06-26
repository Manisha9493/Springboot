package com.wiredbrain.friends.services;

import org.springframework.data.repository.CrudRepository;

import com.wiredbrain.friends.model.Friend;

public interface FriendService extends CrudRepository<Friend, Integer> {

	

}
