package com.example.demo.service;

import java.math.BigInteger;

import com.example.demo.model.ScheduledCar;
public interface ScheduledCarService {

	public ScheduledCar addScheduledCar(ScheduledCar scheduledCar);

	public ScheduledCar modifyScheduledCar(ScheduledCar scheduledCar);

	public String removeScheduledCar(BigInteger id) throws Exception;

	public Iterable<ScheduledCar> viewAllScheduledCar();

	public ScheduledCar viewScheduledCar(BigInteger id) throws Exception;
}
