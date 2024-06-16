package com.sears.service;

import java.util.List;

import com.sears.entity.Product;

public interface ProductService {
	
	Product addProduct(Product product);
	List<Product> getAllProducts();
	int deleteProduct(long productId);
}
