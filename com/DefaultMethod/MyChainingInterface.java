package com.DefaultMethod;

public interface MyChainingInterface {
	
	//49. Demonstrate default method chaining in an interface.
	public default MyChainingInterface step1() {
		System.out.println("Step-1 ");
		return this;
	}
	
	public default MyChainingInterface step2() {
		System.out.println("Step-2 ");
		return this;
	}
	
	public default MyChainingInterface step3() {
		System.out.println("Step-3 ");
		return this;
	}
	
	public abstract void FinalExe();

}
