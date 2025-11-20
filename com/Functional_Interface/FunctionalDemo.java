package com.Functional_Interface;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalDemo {
	public static void main(String[] args) {

		//11. Implement java.util.function.Predicate to check if a number is positive.
		Predicate<Integer> positive = num->num>0;
		System.out.println(positive.test(10));
		System.out.println(positive.test(-5));

		//12. Write a program to check if a string is empty using Function interface.

		Function<String, Boolean> fun = str->str.isEmpty();
		System.out.println(fun.apply(""));
		System.out.println(fun.apply("Surbhi"));

		//14. Write a program that implements Function interface to convert a string to uppercase.
		Function<String, String> fun2 = str2->str2.toUpperCase();
		System.out.println(fun2.apply("surbhi"));

		//13. Implement java.util.function.Consumer to print each element of a list.
		List<String> items = Arrays.asList("Apple", "Surbhi", "Orange", "Chandan", "Shubh");
		Consumer<String> isConsumer = item->System.out.println(item);
		items.forEach(isConsumer);

		//15. Implement UnaryOperator to double a given number
		UnaryOperator<Integer> doubleIt = num->num*2;
		System.out.println(doubleIt.apply(6));

		//16. Implement BinaryOperator to add two numbers.
		BinaryOperator<Integer> addNum = (a,b)->a+b;
		System.out.println(addNum.apply(3, 4));

		//17. Write a program to find the minimum of two numbers using BiFunction.
		BiFunction<Integer, Integer, Integer> min = (a, b)-> a<b ? a:b;
		System.out.println(min.apply(3, 9));
		System.out.println(min.apply(-5, 12));

		//18. Use Predicate to check if a string contains only digits.
		Predicate<String> checkNum = n1->n1.matches("\\d+");
		System.out.println(checkNum.test("abcde"));
		System.out.println(checkNum.test("ä23bc"));
		System.out.println(checkNum.test("1234"));

		//19. Use Supplier to generate random numbers in a range.
		int min1 = 10;
		int max1 = 50;
		Supplier<Integer> randomInRange = () -> {
			Random random = new Random();
			return random.nextInt(max1 - min1 + 1) + min1;
		};
		for (int i = 0; i < 5; i++) {
			System.out.println(randomInRange.get());
		}

		//20. Create a custom functional interface and demonstrate its use with a Lambda expression.
		MyFunctional m = (a,b)->a+b;
		System.out.println(m.addition(5, 60));

	}
}
