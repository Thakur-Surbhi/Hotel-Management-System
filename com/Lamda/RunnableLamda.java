package com.Lamda;

//5. Implement Runnable interface using Lambda expression.
public class RunnableLamda {
	public static void main(String[] args) {
		Runnable t = ()->{
			System.out.println("Thread is running using Lamda");
		};
		
		Thread t1 = new Thread(t);
		t1.start();
		}
	}


