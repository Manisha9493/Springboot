package com.wiredbrain.controller;

import java.util.Optional;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wiredbrain.model.Friends;
import com.wiredbrain.service.FriendService;
import com.wiredbrain.util.ErrorMessage;

@RestController
public class FriendController {

	@Autowired
	FriendService friendService;

	@PostMapping("/create")
	Friends create(@RequestBody Friends friends) throws ValidationException {
		if (friends.getId() == 0 && friends.getFirstName() != null && friends.getLastName() != null) {
			return friendService.save(friends);

		} else
			throw new ValidationException("friend cannot be created");

	}

	@ExceptionHandler(ValidationException.class)
	ResponseEntity<String> exceptionHandler1(ValidationException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	ErrorMessage exceptionHandler(ValidationException e) {
		return new ErrorMessage("400", e.getMessage());
	}

	@GetMapping("/read")
	Iterable<Friends> read() {
		return friendService.findAll();

	}

	@PutMapping("/update")
	ResponseEntity<Friends> update(@RequestBody Friends friends) {
		if (friendService.findById(friends.getId()).isPresent())
			return new ResponseEntity<>(friendService.save(friends), HttpStatus.OK);
		else
			return new ResponseEntity<>(friends, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete/{id}")
	void delete(@PathVariable Integer id) {
		friendService.deleteById(id);
	}

	@GetMapping("/friend/{id}")
	Optional<Friends> read(@PathVariable Integer id) {
		return friendService.findById(id);

	}

	@GetMapping("/friend/search")
	Iterable<Friends> findByQuery(@RequestParam(value = "first", required = true) String firstName,
			@RequestParam(value = "last", required = true) String lastName)

	{
		if (firstName != null && lastName != null) {
			return friendService.findByFirstNameAndLastName(firstName, lastName);
		} else if (firstName != null) {
			return friendService.findByFirstName(firstName);
		} else if (lastName != null) {
			return friendService.findByLastName(lastName);
		} else
			return friendService.findAll();
	}

}
