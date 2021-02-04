package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Car;
public interface CarService {

	public ResponseEntity<?> addCar(Car car);

	public List<Car> viewAllCar();

	public Car viewCar(BigInteger carNumber);

	public Car modifyCar(Car car);

	public String removeCar(BigInteger carNumber);

	
}
