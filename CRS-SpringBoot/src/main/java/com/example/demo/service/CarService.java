package com.example.demo.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Car;
public interface CarService {

	public ResponseEntity<?> addCar(Car car);

	public Iterable<Car> viewAllCar();

	public Car viewCar(BigInteger carNumber);

	public Car modifyCar(Car car);

	public String removeCar(BigInteger carNumber);

	
}
