package com.example.demo.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

@CrossOrigin("http://localhost:4200")
@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired(required= true)
	BookingService bookingService;

	@PostMapping("/createBooking")
	public void addBooking(@RequestBody Booking newBooking) {

		bookingService.createBooking(newBooking);
	}

	@GetMapping("/readAllBooking")
	public List<Booking> readAllBookings() {

		return bookingService.displayAllBooking();
	}

	@PutMapping("/updateBooking")
	public void modifyBooking(@RequestBody Booking updateBooking) {

		bookingService.updateBooking(updateBooking);
	}

	@GetMapping("/searchBooking/{id}")
	public ResponseEntity<?> searchBookingByID(@PathVariable("id") BigInteger bookingId) {

		return bookingService.findBookingById(bookingId);
	}

	@DeleteMapping("/deleteBooking/{id}")
	public void deleteBookingByID(@PathVariable("id") BigInteger bookingId) throws Exception {

		bookingService.deleteBooking(bookingId);
	}
}
