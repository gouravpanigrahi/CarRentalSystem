package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.PlaceDao;
import com.example.demo.exceptions.RecordAlreadyPresentException;
import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.model.Place;

@Service
public class PlaceServiceImpl implements PlaceService{

	@Autowired
	PlaceDao placeDao;

	/*
	 * view all Places
	 */
	@Override
	public List<Place> viewAllPlace() {
		return placeDao.findAll();
	}

	/*
	 * view place by placeCode
	 */
	@Override
	public Place viewPlace(String placeCode) {
		Optional<Place> findById = placeDao.findByPlaceCode(placeCode);
		if (findById.isPresent()) {
			return findById.get();
		}
			
			//return new ResponseEntity<Place>(place, HttpStatus.OK)}
		else
			throw new RecordNotFoundException("Place with place code: " + placeCode + "not exists");
	    }
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
        }*/

	/*
	 * add a place
	 */
	@Override
	public ResponseEntity<?> addPlace(Place place) {
		Optional<Place> findById = placeDao.findByPlaceCode(place.getPlaceCode());
		try {
		if (!findById.isPresent()) {
			placeDao.save(place);
			return new ResponseEntity<Place>(place,HttpStatus.OK);
		} 
		else
			throw new RecordAlreadyPresentException(
					"Place with code : " + place.getPlaceCode() + " already present");
	     }
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<Place>(place,HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * modify an Place
	 */
	@Override
	public Place modifyPlace(Place place) {
		Optional<Place> findById = placeDao.findByPlaceCode(place.getPlaceCode());
		if (findById.isPresent()) {
			placeDao.save(place);
		} 
		else
			throw new RecordNotFoundException("Place with code: " + place.getPlaceCode() + " not exists");
		return place;
	}

	/*
	 * remove an place
	 */
	@Override
	public String removePlace(String placeCode) {
		Optional<Place> findById = placeDao.findByPlaceCode(placeCode);
		if (findById.isPresent()) {
			placeDao.deleteByPlaceCode(placeCode);
			return "Place removed";
		} else
			throw new RecordNotFoundException("Place with code: " + placeCode + " not exists");

	}
	
}
