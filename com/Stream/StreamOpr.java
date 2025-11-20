package com.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOpr {
	public static void main(String[] args) {
		//List<String> list = Arrays.asList("Surbhi", "Chandan", "Namu", "Rashmi", "Diksha", "Shamali");
		//61. Write a program to chain multiple stream operations like filter, map, and collect.

		List<String> names = Arrays.asList("Surbhi", "Mandrele", "Rushikesh", "Madhavi", "Sam", "Sara");
		List<String> filteredName =  names.stream()
				.filter(name-> name.length()>=4)
				.map(String::toUpperCase)
				.filter(name->name.startsWith("S")).collect(Collectors.toList());
		filteredName.forEach(System.out::println);


		//62. Write a program to sort a list of integers in descending order using Stream API.
		List<Integer> num = Arrays.asList(12,23,5,67,23, 67,45);
		List<Integer> res1 = num.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(res1);


		//64. Write a program to collect elements into a set using Collectors.toSet().
		Set<Integer> res2 =num.stream().filter(n->n>=0).collect(Collectors.toSet());
		System.out.println(res2);

		//65. Write a program to group elements based on a condition using Collectors.groupingBy().
		List<String> fruit = Arrays.asList("Apple", "Banana", "Orange", "Gwava", "Mango", "Mango", "Banana");
		Map<String, Long> count= fruit.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		count.forEach((K,V)->System.out.println("Fruit : "+K+" Count : "+V));

		//66. Write a program to find the first even number in a list using Streams.
		List<Integer> num2 = Arrays.asList(23,5,67,23, 67,45, 12, 44,46);
		Optional<Integer> res3 =num2.stream().filter(n->n%2==0).findFirst();
		System.out.println(res3);

		//67. Write a program to partition a list into two based on a condition using Collectors.partitioningBy().
		List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35, 40);
		Map<Boolean, List<Integer>> res5 =numbers.stream().collect(Collectors.partitioningBy(n->n%2==0));
		System.out.println("Even No : "+res5.get(true));
		System.out.println("Odd No : "+res5.get(false));

		//68. Write a program to join elements of a list into a single string using Collectors.joining().
		String res6 = fruit.stream().collect(Collectors.joining(",", "[", "]"));
		System.out.println(res6);

		//69. Write a program to convert a stream to a map using Collectors.toMap().
		List<People> people = Arrays.asList(new People("Surbhi", 30),
				new People("Chandan", 38),
				new People("Amit", 28));
		Map<String, Integer> res7 =people.stream().collect(Collectors.toMap(person->person.name, person->person.age));
		res7.forEach((name, age)->System.out.println(name +"=>"+age));

		//70. Write a program to find the longest string from a list using Stream API.
		Optional<String> res8 = fruit.stream().max(Comparator.comparing(String::length));
		System.out.println(res8);

	}
}
