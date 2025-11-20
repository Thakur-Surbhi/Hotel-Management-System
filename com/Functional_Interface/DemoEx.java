package com.Functional_Interface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoEx {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(2,4,6,23,6,78,98,12);
		List<Integer> evenno= list.stream().filter(n->n%2==0).collect(Collectors.toList());
		System.out.println(evenno);
	}
  }
