package com.adobe.prj.client;

import java.util.stream.IntStream;

public class StreamExample {

	public static void main(String[] args) {
	  /* find sum of even numbers between 1 to 100 */
		
		int sum = IntStream.range(1, 100)
					.filter(no -> no % 2 == 0)
					.reduce(0, (v1, v2) -> v1 + v2);
		
	  	System.out.println("Sum " + sum);
	   
	  	
		
				
	}

}
