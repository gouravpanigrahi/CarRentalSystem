package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Place {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String placeCode;
	private String placeLocation;
	private String placeName;
	private boolean action;

	public Place(Long id, String placeCode, String placeLocation, String placeName, boolean action) {
		this.id = id;
		this.placeCode = placeCode;
		this.placeLocation = placeLocation;
		this.placeName = placeName;
		this.action = action;
	}

	public Place()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isAction() {
		return action;
	}

	public void setAction(boolean action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Place [placeCode=" + placeCode + ", placeLocation=" + placeLocation + ", placeName=" + placeName + "]";
	}
	
}
