package com.DefaultMethod;

public class IDefaultMethod1 implements MyInterface0, MyInterface1, MyInterface2  {

	//42. Create an interface with default method and implement it in a class.
	@Override
	public  void m1() {
		System.out.println("Overridden method in class to avoid conflicts");

		//44. Demonstrate default method in Java 8 with multiple interfaces.
		MyInterface0.super.m1();
		
		//45. Write a program to show conflict between default methods in multiple interfaces.
		MyInterface1.super.m1();
		MyInterface2.super.m1();
		
	}
}
