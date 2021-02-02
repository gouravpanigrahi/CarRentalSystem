package com.example.demo.exceptions;

public class RecordAlreadyPresentException extends RuntimeException{

	public RecordAlreadyPresentException(String s) {
		super(s);
	}
}
