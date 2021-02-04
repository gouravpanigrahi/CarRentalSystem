package com.example.demo.model;

import java.math.BigInteger;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
public class ScheduledCar {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "schedule_car_id")
	private BigInteger scheduleCarId;

	@OneToOne(fetch = FetchType.EAGER)
	@NotNull
	private Car car;

	@Column(name = "available_seats")
	@NotNull
	private Integer availableSeats;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private Schedule schedule;
	
	public ScheduledCar()
	{
		
	}

	public ScheduledCar(Long id, BigInteger scheduleCarId, Car car, Integer availableSeats, Schedule schedule) {
		this.id = id;
		this.scheduleCarId = scheduleCarId;
		this.car = car;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getScheduleCarId() {
		return scheduleCarId;
	}

	public void setScheduleCarId(BigInteger scheduleCarId) {
		this.scheduleCarId = scheduleCarId;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "ScheduledCar [scheduleCarId=" + scheduleCarId + ", car=" + car + ", availableSeats=" + availableSeats
				+ ", schedule=" + schedule + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableSeats == null) ? 0 : availableSeats.hashCode());
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((scheduleCarId == null) ? 0 : scheduleCarId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduledCar other = (ScheduledCar) obj;
		if (availableSeats == null) {
			if (other.availableSeats != null)
				return false;
		} else if (!availableSeats.equals(other.availableSeats))
			return false;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (scheduleCarId == null) {
			if (other.scheduleCarId != null)
				return false;
		} else if (!scheduleCarId.equals(other.scheduleCarId))
			return false;
		return true;
	}
	
}
