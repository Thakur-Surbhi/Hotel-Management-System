package com.multithreading;

/*Write a Java program to demonstrate 
the difference between start() and run() methods.*/

public class MyThread3 extends Thread {

	public void start() {
		System.out.println("Running in Thread " + Thread.currentThread().getName());
	}
	
}
