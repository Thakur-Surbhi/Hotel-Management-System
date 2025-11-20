package com.Optional;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		
		//31. Write a program that demonstrates using Optional to 
		//avoid NullPointerException.
		String name = getName();
		Optional<String> optName = Optional.ofNullable(name);
		
		//32. Write a program that uses Optional.orElse() to 
		//provide a default value when the value is null.
		String Res1 =optName.orElse("Default Name");
		System.out.println("Name : "+Res1);
		
		//33. Write a program to get a value from Optional
		//using map() and perform a transformation.
		Optional<String> res2= optName.map(String::toUpperCase);
		System.out.println("Name : "+res2.orElse("No name provided"));
		
		//34. Demonstrate Optional.filter() by
		//filtering a value if it matches a condition.
		Optional<String> res3 =optName.filter(s->s.matches("\\d+"));
		System.out.println("Valid digits : "+res3);
		
		
        
        
    }

		
	private static String getName() {
		//return "Surbhi";
		return "123";
		
	}
	
	//
}
