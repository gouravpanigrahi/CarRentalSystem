package com.example.demo.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Place;
import com.example.demo.service.PlaceService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/place")
public class PlaceController {
	@Autowired(required = true)
	PlaceService placeService;
	
	@GetMapping("/viewPlace/{id}")
	public Place viewPlace(@PathVariable("id") String placeCode) {
		return placeService.viewPlace(placeCode);
	}
	@GetMapping("/allPlace")
	public List<Place> viewAllPlace() {
		return placeService.viewAllPlace();
	}

	@PostMapping("/addPlace")
	public void addPlace(@RequestBody Place place) {
		placeService.addPlace(place);
	}

	@PutMapping("/updatePlace")
	public void modifyPlace(@RequestBody Place place) {
		placeService.modifyPlace(place);
	}

	@DeleteMapping("/deletePlace/{placeCode}")
	public void removePlace(@PathVariable("placeCode") String placeCode) {
		placeService.removePlace(placeCode);
	}
}
