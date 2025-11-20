package com.DefaultMethod;

public interface MyInterface2 {

	public default void m1() {
		System.out.println("Default method from MyInterface2");
	}
}
