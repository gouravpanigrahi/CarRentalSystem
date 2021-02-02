package com.example.demo.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;
public interface UserDao extends CrudRepository<User, BigInteger> {

}
