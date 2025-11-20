package com.Optional;

import java.util.Optional;

public class OptionalifElseDemo {
	public static void main(String[] args) {
		//39. Write a program to get a default value if 
		//the optional is empty using orElse().
		Optional<String> optVal  = Optional.ofNullable(getString());
		String res= optVal.orElse("Default Value");
		System.out.println("Result : "+res);
		
		//40. Demonstrate Optional.flatMap() to combine two optionals.
		Optional<String> firstName = Optional.of("Surbhi");
		Optional<String> lastName = Optional.of("Thakur");
		//Optional<String> lastName = Optional.ofNullable(null);
		//to Avoid nullPointerExceptation
		Optional<String> fullName = firstName.flatMap(fName->lastName.map(lName->fName + " "+ lName));
		
		System.out.println("Full Name is : "+fullName.orElse("Name Not Available"));
	}

	private static String getString() {
		return null;
	}

}
