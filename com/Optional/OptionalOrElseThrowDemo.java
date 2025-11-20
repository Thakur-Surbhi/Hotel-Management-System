package com.Optional;

import java.util.Optional;

//35. Write a program to return a value from Optional or throw an exception using orElseThrow().
public class OptionalOrElseThrowDemo {
	public static void main(String[] args) {
		String name = getName();
		Optional<String> optName =Optional.ofNullable(name);
		String res = optName.orElseThrow(()-> new IllegalArgumentException("Name can not be null"));
		//String res = optName.orElse("No name provided");
		System.out.println("Name : "+res);
	}

	private static String getName() {
		return "";
	}



}
