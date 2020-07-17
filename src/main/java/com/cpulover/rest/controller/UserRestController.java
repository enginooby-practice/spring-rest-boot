package com.cpulover.rest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cpulover.rest.dao.UserDaoImpl;
import com.cpulover.rest.entity.User;

@RestController
public class UserRestController {
	@Autowired
	private UserDaoImpl userDaoImpl;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userDaoImpl.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = userDaoImpl.findOne(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);

		return user;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userDaoImpl.deleteById(id);

//		if(user==null)
//			throw new UserNotFoundException("id-"+ id);		
	}

	//

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoImpl.save(user);

		// get the uri of new created user
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		// assign the uri to location attribute of the Header of Response
		return ResponseEntity.created(location).build();

	}

}
