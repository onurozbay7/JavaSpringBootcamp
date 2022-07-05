package com.logo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.logo.model.Customer;
import com.logo.model.User;
import com.logo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User createUser(@RequestBody User userRequest) {
		return userService.createUser(userRequest);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PutMapping
	public User updateUser(User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteUser(@PathParam("userId") Integer userId) {
		userService.deleteUserById(userId);
	}

	@GetMapping(value = "/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}

	@GetMapping(value = "/{email}/customers")
	public List<Customer> getCustomersUserByEmail(@PathVariable String email) {
		return userService.getCustomersByEmail(email);
	}

}
