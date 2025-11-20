package com.Optional;

import java.util.Optional;

public class OptionalIfPresentDemo {
	public static void main(String[] args) {
	
		//36. Write a program to demonstrate Optional.ifPresent() 
		//for performing an action when a value is present.
		String name = getName();
		Optional<String> optName = Optional.ofNullable(name);
		optName.ifPresent(msg->System.out.println("Message is "+optName));
		
		//37. Use Optional.empty() to represent no value and handle it gracefully.
		Optional<String> optObj = Optional.empty();
		String result =optObj.orElse("No value available");
		System.out.println("Result : "+result);
		optObj.ifPresent(val->System.out.println("Value : "+val));
		
		//38. Write a program that checks if a given string
		//is present in Optional using isPresent().
		Optional<String> optName1 = Optional.ofNullable(getName());
		
		if(optName1.isPresent()) {
			System.out.println("String Name : "+optName1.get());
		}
		else {
			System.out.println("String not present");
		}
	}

	private static String getName() {
		return "";
	}

}
