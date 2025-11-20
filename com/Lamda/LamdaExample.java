package com.Lamda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LamdaExample {
	public static void main(String[] args) {
		
		//1. Write a Java program to sort a list of integers using Lambda expression.
		List<Integer> numbers = Arrays.asList(3,8,4,6,0,12,45,6,98, 87);
		System.out.println("Before Sorting "+numbers);
		numbers.sort((a,b)->a-b);
		System.out.println("After Sorting "+numbers);
		
		//2. Implement a functional interface and use Lambda to pass its implementation.
		MyFunctionalInterface1 f = ((a,b)->a*b);
		//int result =f.multiple(3, 4);
		//System.out.println("Implementating Functional Interface Multiplication : "+result);
		
		//3. Write a Java program to filter out even numbers from a list using Lambda expression.
		List<Integer> even = Arrays.asList(3,8,4,6,0,12,45,6,98, 87);
		Set<Integer> res1 = even.stream().filter(n->n%2==0).collect(Collectors.toSet());
		System.out.println("Even No using Lamda : "+res1);
		
		//4. Write a program that adds two integers using a Lambda expression.
		MyFunctionalInterface1 f2=((a,b)->a+b);
		int add =f2.addition(4, 5);
		System.out.println("Implementing Functional Interface addition : "+add);
		
		//6. Write a program to multiply all elements of a list using Lambda.
		List<Integer> mul = Arrays.asList(3,8,4, 12,45,67);
		Optional<Integer> res2= mul.stream().reduce((a, b)->a*b);
		System.out.println("Multiplication using Lamda : "+res2);
		
		//7. Write a program to sum the elements of a list using Lambda.
		Optional<Integer> res3 = mul.stream().reduce((a,b)->a+b);
		System.out.println(res3);
		
		//8. Use Lambda expression to reverse a string.
		Function<String, String> s = str-> new StringBuilder(str).reverse().toString();
		String rev= s.apply("Surbhi");
		System.out.println("Resverse of String is : "+rev );
		
		//9. Write a program to compare two strings using Lambda expression.
		BiFunction <String, String, Integer> compareString = (s3, s4)-> s3.compareTo(s4);
		String s1="Surbhi";
		String s2= "Mandrele";
		int res5 = compareString.apply(s1, s2);
		if(res5==0) {
			System.out.println(s1 +" is equal to "+s2);
		}
		else if(res5>0) {
			System.out.println(s1 +" comes before "+s2);
		}
		else
		{
			System.out.println(s1 +" come after "+s2);
		}
		
		
	}

}
