package com.adobe.prj.client;

interface Computation {
	int compute(int x, int y);
}

public class InterfaceExample {

	public static void main(String[] args) {
		// Anonymous class
		Computation add = new Computation() {
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
		};
		
		System.out.println(add.compute(4, 5));
		
		// java 8 lambda expression == >valid only for @FunctionalInterface ==> interface with only one method
		
		Computation subtract = (int x, int y) -> {
			return x - y;
		};
		
		System.out.println(subtract.compute(4, 5));
		
		Computation multiply = (x, y) -> x * y;
		
		System.out.println(multiply.compute(4, 5));
	}

}
