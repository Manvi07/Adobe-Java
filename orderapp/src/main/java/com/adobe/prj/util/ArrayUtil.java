package com.adobe.prj.util;

public class ArrayUtil {
	public static int getSum(int[] elems) {
		int sum = 0;
		for(int elem : elems) {
			sum += elem;
		}
		return sum;
	}
	
	public static int getOccurence(int[] elems, int no) {
		int count = 0;
		for (int i = 0; i < elems.length; i++) {
			if(no == elems[i]) {
				count++;
			}
		}
		return count;
	}
	
}
