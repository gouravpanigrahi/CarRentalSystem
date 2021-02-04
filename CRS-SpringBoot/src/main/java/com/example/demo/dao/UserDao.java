package com.example.demo.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, BigInteger> {

}
