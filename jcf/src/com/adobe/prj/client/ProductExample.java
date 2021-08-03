package com.adobe.prj.client;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.adobe.prj.entity.Product;

public class ProductExample {
	
	public static boolean isMobile(Product p) {
		return p.getCategory().equals("mobile");
	}
	
	public static void main(String[] args) {
		List<Product> products = new LinkedList<Product>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		products.add(new Product(912, "One Plus", 32000.00, "mobile"));
		products.add(new Product(88, "HP Printer", 19000.00, "computer"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer")); // supports duplicate elements

		Collections.sort(products, (p1,p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		
		for(Product p : products) {
			System.out.println(p);
		}
		
		System.out.println("*****************");
		
		products.stream()
//			.filter(p -> p.getCategory().equals("mobile"))
			.filter(ProductExample::isMobile)
			.forEach(p -> System.out.println(p));
		
		System.out.println("***********");
		
		products.stream()
			.map(p -> p.getName())
			.forEach(System.out::println);
		
		System.out.println("print names of mobiles :");
			products.stream()
				.filter(p -> p.getCategory().equals("mobile"))
				.map(p -> p.getName())
				.forEach(System.out::println);
			
		System.out.println("************* Reduce ************* ");
		System.out.println("Sum of product price");
			double total = products.stream()
				.map(p -> p.getPrice())
				.reduce(0.0, (v1, v2) -> v1 + v2);
		
			System.out.println("Total " + total);
		
		System.out.println("********* Group By **********");
		
		Map<String, List<String>> catMap = 
				products.stream().collect(Collectors.groupingBy(p -> p.getCategory(),
                        Collectors.mapping(Product::getName, Collectors.toList())));
		
		catMap.forEach((k,v) -> {
			System.out.println("Category :" + k);
			v.forEach(System.out::println);
		});
		
		System.out.println("*********");
		
		
	}
}
