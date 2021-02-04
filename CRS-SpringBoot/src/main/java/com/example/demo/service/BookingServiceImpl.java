package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.example.demo.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookingDao;
import com.example.demo.model.Booking;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingDao bookingDao;

	@Override
	public ResponseEntity<?> createBooking(Booking newBooking) {

		bookingDao.save(newBooking);
		return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
		// TODO Auto-generated method stub
		//Optional<Booking> findBookingById = bookingDao.findById(newBooking.getBookingId());
//		try {
//			if (!findBookingById.isPresent()) {
//				bookingDao.save(newBooking);
//				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
//			} else
//				throw new Exception(
//						"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
//		} catch (Exception e) {
//
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
	}

	@Override
	public Booking updateBooking(Booking newBooking) {
		// TODO Auto-generated method stub
//		Optional<Booking> findBookingById = bookingDao.findById(newBooking.getBookingId());
//		if (findBookingById.isPresent()) {
//			bookingDao.save(newBooking);
//		} else
//			throw new RecordNotFoundException(
//					"Booking with Booking Id: " + newBooking.getBookingId() + " not exists!!");
		return newBooking;

	}

	@Override
	public String deleteBooking(BigInteger bookingId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Booking> findBookingById = bookingDao.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookingDao.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new Exception("Booking not found for the entered BookingID");
		
	}

	@Override
	public List<Booking> displayAllBooking() {
		// TODO Auto-generated method stub
		return bookingDao.findAll();
	}

	@Override
	public ResponseEntity<?> findBookingById(BigInteger bookingId) {
		// TODO Auto-generated method stub
		Optional<Booking> findById = bookingDao.findById(bookingId);
		try {
			if (findById.isPresent()) {
				Booking findBooking = findById.get();
				return new ResponseEntity<Booking>(findBooking, HttpStatus.OK);
			} else
				throw new Exception("No record found with ID " + bookingId);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
