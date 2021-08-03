package com.adobe.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsType {

	public static void main(String[] args) {
		List<Integer> iList = Arrays.asList(2, 6,212,7);
		List<Double> dList = new ArrayList<>();
		dList.add(3.66);
		dList.add(72.22);
		
		
		List<?> list = iList;
//		list.add(44); // won't allow mutation
		System.out.println(list.get(0));
		
		list = dList;
		System.out.println(list.get(0));
		
		// collections are not co-variant ==> no upcasting
//		List<Object> l = iList; 
		
	}

}
