package com.example.demo.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired(required = true)
	CarService carService;

	@PostMapping("/addCar")
	public void addCar(@RequestBody Car car) {
		carService.addCar(car);
	}

	@GetMapping("/allCar")
	public List<Car> viewAllCar() {
		return carService.viewAllCar();
	}

	@GetMapping("/viewCar/{id}")
	public Car viewCar(@PathVariable("id") BigInteger carNo) {
		return carService.viewCar(carNo);
	}

	@PutMapping("/updateCar")
	public void modifyCar(@RequestBody Car car) {
		carService.modifyCar(car);
	}

	@DeleteMapping("/deleteCar/{id}")
	public void removeCar(@PathVariable("id") BigInteger carNo) {
		carService.removeCar(carNo);
	}
}
