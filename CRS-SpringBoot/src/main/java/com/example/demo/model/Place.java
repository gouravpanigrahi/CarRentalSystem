package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Place {

	@Id
	private String placeCode;
	private String placeLocation;
	private String placeName;
	public Place(String placeCode, String placeLocation, String placeName) {
		super();
		this.placeCode = placeCode;
		this.placeLocation = placeLocation;
		this.placeName = placeName;
	}

	public Place()
	{
		
	}

	public String getPlaceCode() {
		return placeCode;
	}

	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}

	public String getPlaceLocation() {
		return placeLocation;
	}

	public void setPlaceLocation(String placeLocation) {
		this.placeLocation = placeLocation;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	@Override
	public String toString() {
		return "Place [placeCode=" + placeCode + ", placeLocation=" + placeLocation + ", placeName=" + placeName + "]";
	}
	
}
