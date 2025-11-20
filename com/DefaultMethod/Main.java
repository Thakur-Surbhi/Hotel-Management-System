package com.DefaultMethod;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main 
 {
	public static void main(String[] args) {
		
		//42. Create an interface with default method and implement it in a class.
		//43. Write a program where an interface has a default method and a class overrides it.
		IDefaultMethod1 m = new IDefaultMethod1();
		m.m1();
		
		//46. Create an interface with default methods and use it in a lambda expression.
		MyFunctionalInterface f = (name)->System.out.println("Hello "+name);
		f.Welcome("Surbhi");
		f.GoodWish("Surbhi");
		
		//47. Write a program that demonstrates multiple default methods in an interface.
		m.m2();
		m.m3();
		
		//49. Demonstrate default method chaining in an interface.
		MyChainingInterface c = new ChainingMain();
		c.step1().step2().step3().FinalExe();
		
		
		//50. Write a program to show default methods used in stream processing.
		List<String> names = Arrays.asList("  Surbhi  ","  Mandrele ", " Java8  ", " Spring", "  Microservices  ");
		Process p = (input)->input+" action has perform";
		List<String> result = names.stream().map(p::toUpperCase).map(p::trim).map(p::process).collect(Collectors.toList());
		result.forEach(System.out::println);
		
		}

	}


