package com.example.demo.controller;

import java.math.BigInteger;
import java.util.List;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public void addUser(@RequestBody User user) {

		userService.createUser(user);
	}

	@GetMapping("/readAllUsers")
	public List<User> readAllUsers() {

		return userService.displayAllUser();
	}

	@PutMapping("/updateUser")
	public void updateUser(@RequestBody User updateUser) {

		userService.updateUser(updateUser);
	}

	@GetMapping("/searchUser/{userId}")
	public ResponseEntity<?> searchUserByID(@PathVariable("userId") BigInteger userId) {

		return userService.findUserById(userId);
	}

	@DeleteMapping("/deleteUser/{id}")
	public void deleteBookingByID(@PathVariable("id") BigInteger userId) {

		userService.deleteUser(userId);
	}
}
