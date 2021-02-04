package com.example.demo.service;

import java.math.BigInteger;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.exceptions.RecordAlreadyPresentException;
import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.model.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public ResponseEntity<?> createUser(User newUser) {
		// TODO Auto-generated method stub
		Optional<User> findUserById = userDao.findById(newUser.getUserId());
		try {
			if (!findUserById.isPresent()) {
				userDao.save(newUser);
				return new ResponseEntity<User>(newUser, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"User with Id: " + newUser.getUserId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public User updateUser(User updateUser) {
		// TODO Auto-generated method stub
		Optional<User> findUserById = userDao.findById(updateUser.getUserId());
		if (findUserById.isPresent()) {
			userDao.save(updateUser);
		} else
			throw new RecordNotFoundException(
					"User with Id: " + updateUser.getUserId() + " not exists!!");
		return updateUser;
	}

	@Override
	public String deleteUser(BigInteger UserId) {
		// TODO Auto-generated method stub
		Optional<User> findBookingById = userDao.findById(UserId);
		if (findBookingById.isPresent()) {
			userDao.deleteById(UserId);
			return "User Deleted!!";
		} else
			throw new RecordNotFoundException("User not found for the entered UserID");
	}

	@Override
	public List<User> displayAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public ResponseEntity<?> findUserById(BigInteger userId) {
		// TODO Auto-generated method stub
		Optional<User> findById = userDao.findById(userId);
		try {
			if (findById.isPresent()) {
				User findUser = findById.get();
				return new ResponseEntity<User>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
