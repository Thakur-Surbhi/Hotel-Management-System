package com.example.demo.exception;

public class ResourseNotFoundException extends RuntimeException {

	public ResourseNotFoundException (String s) {
		super(s);
	}
	
	public ResourseNotFoundException() {
		super("Resourse not found !!");
	}
}
