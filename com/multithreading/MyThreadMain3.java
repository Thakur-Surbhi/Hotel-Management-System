package com.multithreading;

public class MyThreadMain3 {
	public static void main(String[] args) {
		MyThread3 t = new MyThread3();
		MyThread3 t1 = new MyThread3();
		MyThread3 t2 = new MyThread3();
		MyThread3 t3 = new MyThread3();

		System.out.println("Calling run() method Directly...!");
		t.run();

		t.start();
		System.out.println("Calling start() method Directly...!");

		//6. Write a Java program to set the name of a thread.
		t.setName("Custom Thread - 1");
		t.start();
		System.out.println("Main Thread Name - > !"+Thread.currentThread().getName());

		//7. Write a Java program to set the priority of a thread.
		t1.setName("Min Priority Thread");
		t2.setName("Normal Priority Thread");
		t3.setName("Max Priority Thread");
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}

}
