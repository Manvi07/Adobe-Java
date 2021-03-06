package com.adobe.prj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adobe.prj.dao.OrderDao;
import com.adobe.prj.dto.ReportDTO;
import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Item;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@SpringBootApplication
public class OrderappApplication implements CommandLineRunner {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired(required = false)
	private OrderDao orderDao;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderappApplication.class, args);
	}
	
	// get called once spring container is created
	@Override
	public void run(String... args) throws Exception {
//		listProducts();
//		addProduct();
		
//		getCustomer();
//		createOrder();
//		customQuery();
	}

	private void customQuery() {
//		List<Product> products = orderService.getProductsPriceRange(5000, 1_00_000);
//		for(Product p : products) {
//			System.out.println(p);
//		}
		
		List<ReportDTO> reports = orderDao.getReport();
		for(ReportDTO r : reports) {
			System.out.println(r.getEmail() +", " + r.getFirstName() +", " + r.getOrderDate() +", " + r.getTotal());
		}
	}

	private void createOrder() {
		Customer c = new Customer();
		c.setEmail("sam@adobe.com");
		
		Order o = new Order(); 
		o.setCustomer(c);
		
		Product p1 = new Product();
		p1.setId(4);
		
		Product p2 = new Product();
		p2.setId(2);
		
		Item i1 = new Item();
		i1.setProduct(p1);
		i1.setQty(3);
		
		Item i2 = new Item();
		i2.setProduct(p2);
		i2.setQty(1);
		
		o.getItems().add(i1);
		o.getItems().add(i2);
		
		orderService.placeOrder(o);
	}

	private void getCustomer() {
		Customer c = orderService.getCustomer("sam@adobe.com");
		System.out.println(c);
	}

	private void addProduct() {
		Product p = new Product(0,"Tata Sky Settop box", 5400, "tv");
		p.setQuantity(100);
		orderService.addProduct(p);
	}

	private void listProducts() {
		List<Product> products = orderService.getProducts();
		for(Product p : products) {
			System.out.println(p);
		}
	}

}
