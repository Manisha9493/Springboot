package com.wiredbrain.friends.services;

import org.springframework.data.repository.CrudRepository;

import com.wiredbrain.friends.model.Address;

public interface AddressService extends CrudRepository<Address, Integer>{

}
