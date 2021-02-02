package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ScheduleDao;
import com.example.demo.dao.ScheduledCarDao;
import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.exceptions.ScheduledCarNotFoundException;
import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduledCar;

@Service
public class ScheduledCarImpl implements ScheduledCarService  {

	@Autowired
	ScheduledCarDao dao;

	@Autowired
	ScheduleDao scheduleDao;

	@Autowired
	BookingService bookingService;

	@Override
	public ScheduledCar addScheduledCar(ScheduledCar scheduledCar) {
		// TODO Auto-generated method stub
		return dao.save(scheduledCar);
	}

	@Override
	public ScheduledCar modifyScheduledCar(ScheduledCar scheduleCar) {
		ScheduledCar updateScheduleCar = dao.findById(scheduleCar.getScheduleCarId()).get();
		Schedule updateSchedule = scheduleDao.findById(scheduleCar.getSchedule().getScheduleId()).get();
		updateScheduleCar.setAvailableSeats(scheduleCar.getAvailableSeats());
		updateSchedule.setSrcPlace(scheduleCar.getSchedule().getSrcPlace());
		updateSchedule.setDstnPlace(scheduleCar.getSchedule().getDstnPlace());
		updateSchedule.setArrDateTime(scheduleCar.getSchedule().getArrDateTime());
		updateSchedule.setDeptDateTime(scheduleCar.getSchedule().getDeptDateTime());
		dao.save(updateScheduleCar);
		return scheduleCar;
	}
		

	@Override
	public String removeScheduledCar(BigInteger id) throws Exception {
		// TODO Auto-generated method stub
		if (id == null)
			throw new RecordNotFoundException("Enter car Id");
		Optional<ScheduledCar> scheduleCar = dao.findById(id);
		if (!scheduleCar.isPresent())
			throw new RecordNotFoundException("Enter a valid Car Id");
		else {
			dao.deleteById(id);
		}
		return "Scheduled car with ID " + id + " is not found";
	}

	@Override
	public Iterable<ScheduledCar> viewAllScheduledCar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public ScheduledCar viewScheduledCar(BigInteger id) throws Exception {
		// TODO Auto-generated method stub
		if (id == null)
			throw new ScheduledCarNotFoundException("Enter car Id");
		Optional<ScheduledCar> scheduleCar = dao.findById(id);
		if (!scheduleCar.isPresent())
			throw new ScheduledCarNotFoundException("Enter a valid Flight Id");
		else
			return scheduleCar.get();
	}
}
