package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Place;

public interface PlaceService {
	public Iterable<Place> viewAllPlace();

	public Place viewPlace(String placeCode);

	public ResponseEntity<?> addPlace(Place place);

	public Place modifyPlace(Place place);

	public String removePlace(String placeCode);
}
