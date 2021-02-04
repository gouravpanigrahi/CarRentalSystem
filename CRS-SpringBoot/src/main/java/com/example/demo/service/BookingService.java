package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Booking;


public interface BookingService {

	public ResponseEntity<?> createBooking(Booking newBooking);

	public Booking updateBooking(Booking newBooking);

	public String deleteBooking(BigInteger bookingId) throws Exception;

	public List<Booking> displayAllBooking();

	public ResponseEntity<?> findBookingById(BigInteger bookingId);
}
