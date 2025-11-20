package com.multithreading;

public class MyThreadMain2 {
	public static void main(String[] args) {
		MyThread2 rb = new MyThread2();
		Thread t= new Thread(rb);
		t.start();
	}

}
