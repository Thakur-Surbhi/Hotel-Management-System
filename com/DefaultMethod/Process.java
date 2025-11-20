package com.DefaultMethod;

@FunctionalInterface
public interface Process {
	
	String process(String input);
	
	default String toUpperCase(String input) {
		return input.toUpperCase();
	}
	
	default String trim (String input) {
		return input.trim();
		
	}

}
