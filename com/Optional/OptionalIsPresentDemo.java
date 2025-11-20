package com.Optional;

import java.util.Optional;

public class OptionalIsPresentDemo {

	public static void main(String[] args) {
		Optional<Object> optString = Optional.ofNullable(getString());
		//Optional<Object> optString = Optional.ofNullable(null);

		if(optString.isPresent()) {
			System.out.println("Value is present: " + optString.get());
		}
		else {
			System.out.println("No value present");
		}
	}

	private static Object getString() {
		return "Surbhi";
	}	

}
