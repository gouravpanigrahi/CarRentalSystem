package com.example.demo.model;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Car {

	@Id
	private BigInteger CarNo;
	private String carName;
	private String carModel;
	private int seatCapacity;
	
	public Car() {
	}

	public Car(BigInteger carNo, String carName, String carModel, int seatCapacity) {
		super();
		CarNo = carNo;
		this.carName = carName;
		this.carModel = carModel;
		this.seatCapacity = seatCapacity;
	}

	public BigInteger getCarNo() {
		return CarNo;
	}

	public void setCarNo(BigInteger carNo) {
		CarNo = carNo;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Car [CarNo=" + CarNo + ", carName=" + carName + ", carModel=" + carModel + ", seatCapacity="
				+ seatCapacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CarNo == null) ? 0 : CarNo.hashCode());
		result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
		result = prime * result + ((carName == null) ? 0 : carName.hashCode());
		result = prime * result + seatCapacity;
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
		Car other = (Car) obj;
		if (CarNo == null) {
			if (other.CarNo != null)
				return false;
		} else if (!CarNo.equals(other.CarNo))
			return false;
		if (carModel == null) {
			if (other.carModel != null)
				return false;
		} else if (!carModel.equals(other.carModel))
			return false;
		if (carName == null) {
			if (other.carName != null)
				return false;
		} else if (!carName.equals(other.carName))
			return false;
		if (seatCapacity != other.seatCapacity)
			return false;
		return true;
	}
	
	
}
