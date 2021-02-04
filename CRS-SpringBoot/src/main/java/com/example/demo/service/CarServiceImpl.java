package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.CarDao;
import com.example.demo.exceptions.RecordAlreadyPresentException;
import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.model.Car;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarDao carDao;

	@Override
	public ResponseEntity<?> addCar(Car car) {
		// TODO Auto-generated method stub
		Optional<Car> findById = carDao.findByCarNo(car.getCarNo());
		try {
		if (!findById.isPresent()) {
			carDao.save(car);
			return new ResponseEntity<Car>(car,HttpStatus.OK);
		} else
			throw new RecordAlreadyPresentException("Car with number: " + car.getCarNo() + " already present");
	}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Car> viewAllCar() {
		// TODO Auto-generated method stub
		return carDao.findAll();
	}

	@Override
	public Car viewCar(BigInteger carNumber) {
		// TODO Auto-generated method stub
		Optional<Car> car = carDao.findByCarNo(carNumber);
		System.out.println("car.isPresent()----"+car.get());
		if (car.isPresent()) {
			System.out.println("Car----"+car.get());
			return car.get();
		}
		else
			throw new RecordNotFoundException("Car with number: " + carNumber + " not exists");
	    }
	

	@Override
	public Car modifyCar(Car car) {
		// TODO Auto-generated method stub
		Optional<Car> findById = carDao.findByCarNo(car.getCarNo());
		if (findById.isPresent()) {
			carDao.save(car);
		} else
			throw new RecordNotFoundException("Car with number: " + car.getCarNo() + " not exists");
		return car;
		
	}

	@Override
	public String removeCar(BigInteger carNumber) {
		// TODO Auto-generated method stub
		Optional<Car> car = carDao.findByCarNo(carNumber);
		if (car.isPresent()) {
			carDao.deleteByCarNo(carNumber);
			return "Car removed!!";
		} else
			throw new RecordNotFoundException("Car with number: " + carNumber + " not exists");
	}

}
