package com.adobe.prj.client;

import java.util.Arrays;
import java.util.Comparator;

import com.adobe.prj.entity.Product;

public class ArraysExample {

	public static void main(String[] args) {
		String[] names = { "George", "Brad", "Charles", "Angelina", "Lee" };
		Arrays.sort(names);

		for (String name : names) {
			System.out.println(name);
		}

		System.out.println("*********");

		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		for (String name : names) {
			System.out.println(name);
		}

		System.out.println("**********");
		Arrays.sort(names, (o1, o2) -> o1.length() - o2.length());

		for (String name : names) {
			System.out.println(name);
		}

		System.out.println("********** Products **************");
		Product[] products = new Product[6];
		products[0] = new Product(645, "Hp Laptop", 135000.00, "computer");
		products[1] = new Product(224, "iPhone", 98000.00, "mobile");
		products[2] = new Product(834, "Logitech Mouse", 600.00, "computer");
		products[3] = new Product(5, "Sony Bravia", 125000.00, "tv");
		products[4] = new Product(912, "One Plus", 32000.00, "mobile");
		products[5] = new Product(88, "HP Printer", 19000.00, "computer");

		Arrays.sort(products);

		for (Product p : products) {
			System.out.println(p);
		}

		System.out.println("Products sorted by Price using lambda expression:");

//		Arrays.sort(products, (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));

		Arrays.sort(products, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		
		for (Product p : products) {
			System.out.println(p);
		}
	}

}
