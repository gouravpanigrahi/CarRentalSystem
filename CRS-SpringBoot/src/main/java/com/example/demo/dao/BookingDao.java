package com.example.demo.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Booking;
@Repository
public interface BookingDao extends JpaRepository<Booking, BigInteger> {
	
}
