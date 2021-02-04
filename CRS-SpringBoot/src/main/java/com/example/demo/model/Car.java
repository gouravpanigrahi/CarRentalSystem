package com.example.demo.model;

import java.math.BigInteger;

import javax.persistence.*;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private BigInteger carNo;
	private String carName;
	private String carModel;
	private int seatCapacity;
	private boolean action;
	
	public Car() {
	}

	public Car(Long id, BigInteger carNo, String carName, String carModel, int seatCapacity, boolean action) {
		this.id = id;
		this.carNo = carNo;
		this.carName = carName;
		this.carModel = carModel;
		this.seatCapacity = seatCapacity;
		this.action = action;
	}

	public boolean isAction() {
		return action;
	}

	public void setAction(boolean action) {
		this.action = action;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getCarNo() {
		return carNo;
	}

	public void setCarNo(BigInteger carNo) {
		this.carNo = carNo;
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
		return "Car [CarNo=" + carNo + ", carName=" + carName + ", carModel=" + carModel + ", seatCapacity="
				+ seatCapacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carNo == null) ? 0 : carNo.hashCode());
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
		if (carNo == null) {
			if (other.carNo != null)
				return false;
		} else if (!carNo.equals(other.carNo))
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
