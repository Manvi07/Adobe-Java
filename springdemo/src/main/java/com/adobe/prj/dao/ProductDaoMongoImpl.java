package com.adobe.prj.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.adobe.prj.entity.Product;

@Repository
@Profile("dev")
public class ProductDaoMongoImpl implements ProductDao {

	@Override
	public void addProduct(Product p) {
		System.out.println("mongo store!!");
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
