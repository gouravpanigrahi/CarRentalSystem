package com.example.demo.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.User;


public interface UserService {

	public ResponseEntity<?> createUser(User newUser);

	public User updateUser(User newUser);

	public String deleteUser(BigInteger UserId);

	public Iterable<User> displayAllUser();

	public ResponseEntity<?> findUserById(BigInteger userId);
}