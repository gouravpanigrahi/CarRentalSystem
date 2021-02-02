package com.example.demo.exceptions;

public class ScheduledCarNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ScheduledCarNotFoundException(String str) {
		super(str);
	}
}
