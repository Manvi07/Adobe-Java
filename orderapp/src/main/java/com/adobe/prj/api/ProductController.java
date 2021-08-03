package com.adobe.prj.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/products")
@Api(value = "products controller")
public class ProductController {
	@Autowired
	private OrderService service;
	
	// http://localhost:8080/api/products
	// http://localhost:8080/api/products?low=1000&high=50000
	@ApiOperation(value = "fetch all products")
	@GetMapping()
	public @ResponseBody List<Product> getProducts(@RequestParam(name = "low", defaultValue = "0.0") double low,
			@RequestParam(name="high", defaultValue =  "0.0") double high) {
		if(low == 0.0 && high == 0.0) {
			return service.getProducts();
//			return Arrays.asList(new Product(1, "a",  500.00, "c1"), new Product(2, "b",   1500.00, "c2"));
		} else {
			return service.getProductsPriceRange(low, high);
		}
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Product getProduct(@PathVariable("id") int id) throws NotFoundException {
		return service.getProductById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody Product addProduct(@RequestBody @Valid Product p) {
		return service.addProduct(p);
	}
	
	
	@PutMapping("/{id}")
	public @ResponseBody Product modifyProduct(@PathVariable("id") int id, @RequestBody Product p) {
		return service.updateProduct(id, p.getPrice());
	}
}
