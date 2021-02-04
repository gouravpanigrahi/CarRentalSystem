package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Place;

import java.util.List;

public interface PlaceService {
	public List<Place> viewAllPlace();

	public Place viewPlace(String placeCode);

	public ResponseEntity<?> addPlace(Place place);

	public Place modifyPlace(Place place);

	public String removePlace(String placeCode);
}
