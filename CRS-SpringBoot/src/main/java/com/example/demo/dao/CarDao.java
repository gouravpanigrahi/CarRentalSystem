package com.example.demo.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;
@Repository
public interface CarDao extends CrudRepository<Car,BigInteger>{

}
