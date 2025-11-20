package com.Stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelStreamOpr {
	public static void main(String[] args) {

		//71. Write a program to sum elements of a large list using parallel stream.
		List<Integer> largeList = IntStream.rangeClosed(0, 1_000_000).boxed().collect(Collectors.toList());

		//Long sum =largeList.parallelStream().mapToLong(Integer::longValue).sum();
		//System.out.println(sum);

		//Sequential 
		long stratSequential = System.currentTimeMillis();
		Long sumSequential =largeList.stream().mapToLong(Integer::longValue).sum();
		long endSequential = System.currentTimeMillis();
		System.out.println("Sequential Sum : "+sumSequential);
		System.out.println("Time Taken sequencial : "+(endSequential-stratSequential)+"ms");

		//Parallel
		long stratParallel = System.currentTimeMillis();
		Long sumParallel =largeList.parallelStream().mapToLong(Integer::longValue).sum();
		long endParallel = System.currentTimeMillis();
		System.out.println("Sequential Sum : "+sumParallel);
		System.out.println("Time Taken Parallel : "+(endParallel-stratParallel)+"ms");


		//73. Write a program to calculate the factorial of a number using parallel stream.
		int numbers =5;
		long fact =LongStream.rangeClosed(1, numbers).parallel().reduce(1,(a,b)->a*b);
		System.out.println("Factorial of a numbert is : "+fact);

		//74. Demonstrate parallel stream for performing an expensive operation.
		//76. Write a program to demonstrate parallelism with map() operation.
		List<String> items = Arrays.asList("A", "B", "C", "D", "E");

		System.out.println("Sequential Stream:");
		long startSequential1 = System.currentTimeMillis();
		items.stream()
		.map(ParallelStreamOpr::expensiveOperation)
		.forEach(System.out::println);
		long endSequential1 = System.currentTimeMillis();
		System.out.println("Time taken (Sequential): " + (endSequential1 - startSequential1) + " ms");

		System.out.println("\nParallel Stream:");
		long startParallel1 = System.currentTimeMillis();
		items.parallelStream()
		.map(ParallelStreamOpr::expensiveOperation)
		.forEach(System.out::println);
		long endParallel1 = System.currentTimeMillis();
		System.out.println("Time taken (Parallel): " + (endParallel1 - startParallel1) + " ms");


		//75. Write a program to sort a large list of integers using parallel stream.

		List<Integer> largeList1 = new Random().ints(1_000_000, 1,
				1_000_000).boxed().collect(Collectors.toList()); 

		// Shuffle to ensure randomness
		Collections.shuffle(largeList1);
		long startTime = System.currentTimeMillis();
		List<Integer> sortedList = largeList1.parallelStream().sorted().collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		System.out.println("Sorted first 10 elements : "+sortedList.subList(0, 10));
		System.out.println("Time taken (Parallel Sort ) : "+(endTime-startTime)+"ms");

		//77. Write a program to find the sum of squares of a list of integers using parallel stream.
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int seq = numbers1.parallelStream().map(n->n*n).reduce(0, Integer::sum);
		System.out.println("Sum of sequares is : "+seq);
		
		//78. Write a program to filter prime numbers from a list using parallel stream.

		List<Integer> numbers2 = Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		List<Integer> primeNoList =numbers2.parallelStream().filter(ParallelStreamOpr::isPrime).collect(Collectors.toList());
		System.out.println(primeNoList);
		
		//79. Demonstrate the use of parallel streams with Collectors.groupingBy().
		Map<String, List<Integer>> evenOdd = numbers2.parallelStream().collect(Collectors.groupingBy(n->n%2==0 ? "Even" : "Odd"));
		evenOdd.forEach((Even, Odd)->System.out.println("EvenList - "+Even+"OddList - "+Odd));
		
		//80. Write a program to calculate average using parallel streams.
		double avg =numbers2.parallelStream().mapToInt(Integer::intValue).average().orElse(0.0);
		System.out.println("Average of no is : "+avg);
	}	
	
	private static boolean isPrime( int number) {
		if(number<=1) return false;
		if(number==2) return true;
		if(number%2==0) return false;
		for(int i=3; i<=Math.sqrt(number); i=i+2) {
			if(number%i==0)
				return false;
		}
				
		return true;
	}

	private static String expensiveOperation(String item) {
		try {
			Thread.sleep(1000); // Simulate delay
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return "Processed: " + item;
	}

}








