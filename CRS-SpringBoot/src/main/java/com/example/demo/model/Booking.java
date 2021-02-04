package com.example.demo.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "BOOKING")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private BigInteger carNo;
	private Date bookingDateFrom;
	private Date bookingDateTo;

	public Booking(Long id, BigInteger carNo, Date bookingDateFrom, Date bookingDateTo) {
		this.id = id;
		this.carNo = carNo;
		this.bookingDateFrom = bookingDateFrom;
		this.bookingDateTo = bookingDateTo;
	}

	public Booking() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getCarNo() {
		return carNo;
	}

	public void setCarNo(BigInteger carNo) {
		this.carNo = carNo;
	}

	public Date getBookingDateFrom() {
		return bookingDateFrom;
	}

	public void setBookingDateFrom(Date bookingDateFrom) {
		this.bookingDateFrom = bookingDateFrom;
	}

	public Date getBookingDateTo() {
		return bookingDateTo;
	}

	public void setBookingDateTo(Date bookingDateTo) {
		this.bookingDateTo = bookingDateTo;
	}
}

