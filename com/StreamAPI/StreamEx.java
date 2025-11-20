package com.StreamAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamEx {
	public static void main(String[] args) {
		
		//21. Write a program to filter odd numbers from a list using Streams.
		List<Integer> num = Arrays.asList(3,2,4,6,7,8,9,10, 12, 10, 11,6,8, 101);
		List<Integer> res =num.stream().filter(n->n%2!=0).collect(Collectors.toList());
		System.out.println(res);
		
		//22. Write a program to convert a list of integers to a list of squares using map().
		List<Integer> res2 = num.stream().map(n->n*n).collect(Collectors.toList());
		System.out.println(res2);
		
		//23. Write a program to find the maximum element from a list using Streams.
		Integer res3= num.stream().max(Integer::compare).orElseThrow();
		System.out.println(res3);
		
		//24. Write a program to count how many elements in a list are greater than 10 using filter().
		List<Integer> res4=num.stream().filter(n1->n1>10).collect(Collectors.toList());
		System.out.println(res4);
		
		//25. Write a program to sort a list of strings using Stream.
		List<String> list = Arrays.asList("Abhay", "Surbhi", "Chandan", "Rishi", "Gokhale");
		List<String> res5 = list.stream().sorted().collect(Collectors.toList());
		System.out.println(res5);
		
		//26. Write a program to find the sum of all elements in a list using reduce().
		Optional<Integer> res6 =num.stream().reduce((a,b)->a+b);
		System.out.println(res6);
		
		//27. Write a program to remove duplicates from a list using distinct() in a stream.
		List<Integer> res7 = num.stream().sorted().distinct().collect(Collectors.toList());
		System.out.println(res7);
		
		//28. Use flatMap() to flatten a list of lists into a single list.
		List<String> list1 = Arrays.asList("one", "two", "three");
		List<String> list2 = Arrays.asList("four", "five");
		List<List<String>> finalList = Arrays.asList(list1,list2);
		List<String> res8 = finalList.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(res8);
		
		//29. Write a program to check if any element in the list is greater than 100 using anyMatch().
		boolean res9=num.stream().anyMatch(n2->n2>100);
		System.out.println(res9);
		
		//30. Write a program to find the average of a list of integers using Streams.
		double res10=num.stream().mapToInt(Integer::intValue).average().orElse(0.0);
		System.out.println(res10);
	}

}
