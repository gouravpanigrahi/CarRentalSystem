package com.example.demo.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.exceptions.ScheduledCarNotFoundException;
import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduledCar;
import com.example.demo.service.CarService;
import com.example.demo.service.PlaceService;
import com.example.demo.service.ScheduledCarService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/scheduledCar")
public class ScheduledCarController {

	/*
	 * Creating Service object
	 */
	@Autowired
	ScheduledCarService scheduleCarService;

	@Autowired
	PlaceService placeService;

	@Autowired
	CarService carService;

	/*
	 * Controller for adding Scheduled Cars
	 */
	@PostMapping("/add")
	public ResponseEntity<ScheduledCar> addSC(@ModelAttribute ScheduledCar scheduledCar,
			@RequestParam(name = "srcPlace") String source, @RequestParam(name = "dstnPlace") String destination,
			@RequestParam(name = "deptDateTime") String departureTime, @RequestParam(name = "arrDateTime") String arrivalTime) {
		Schedule schedule = new Schedule();
		schedule.setScheduleId(scheduledCar.getScheduleCarId());
		try {
			schedule.setSrcPlace(placeService.viewPlace(source));
		} catch (RecordNotFoundException e) {
			return new ResponseEntity("Place Not Found", HttpStatus.BAD_REQUEST);
		}
		try {
			schedule.setDstnPlace(placeService.viewPlace(destination));
		} catch (RecordNotFoundException e) {
			return new ResponseEntity("Place Not Found", HttpStatus.BAD_REQUEST);
		}
		schedule.setDeptDateTime(departureTime);
		schedule.setArrDateTime(arrivalTime);
		try {
			scheduledCar.setCar(carService.viewCar(scheduledCar.getScheduleCarId()));
		} catch (RecordNotFoundException e1) {
			return new ResponseEntity("Place Not Found", HttpStatus.BAD_REQUEST);
		}
		scheduledCar.setSchedule(schedule);
		scheduledCar.setAvailableSeats(scheduledCar.getCar().getSeatCapacity());
		try {
			return new ResponseEntity<ScheduledCar>(scheduleCarService.addScheduledCar(scheduledCar),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Error adding Flight." + e, HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * Controller for modifying existing Scheduled Cars
	 */
	@PutMapping("/modify")
	public ResponseEntity<ScheduledCar> modifyScheduleCar(@ModelAttribute ScheduledCar scheduleCar) {
		ScheduledCar modifySCar = scheduleCarService.modifyScheduledCar(scheduleCar);
		if (modifySCar == null) {
			return new ResponseEntity("Car not modified", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ScheduledCar>(modifySCar, HttpStatus.OK);
		}

	}

	/*
	 * Controller for deleting existing Scheduled Cars
	 */
	@DeleteMapping("/delete")
	public String deleteSC(@RequestParam BigInteger carId) throws Exception {
		return scheduleCarService.removeScheduledCar(carId);
	}

	/*
	 * Controller for viewing a Scheduled Car by ID
	 */
	@GetMapping("/search")
	public ResponseEntity<ScheduledCar> viewSC(@RequestParam BigInteger carId) throws Exception {
		ScheduledCar searchSCar = scheduleCarService.viewScheduledCar(carId);
		if (searchSCar == null) {
			return new ResponseEntity("Car not present", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ScheduledCar>(searchSCar, HttpStatus.OK);
		}
	}

	/*
	 * Controller for viewing all Scheduled Cars
	 */
	@GetMapping("/viewAll")
	public Iterable<ScheduledCar> viewAllSC() {
		return scheduleCarService.viewAllScheduledCar();
	}
}
