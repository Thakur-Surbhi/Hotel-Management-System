package com.DefaultMethod;

@FunctionalInterface
public interface MyFunctionalInterface {
	public void Welcome(String name);
	
	//48. Create a default method in a functional interface and demonstrate its use.
	public default void GoodWish(String name) {
		System.out.println("All The best "+name);
	}

}
