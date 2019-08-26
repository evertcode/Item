package com.evertcode.app.product.models.service;

import java.util.List;

import com.evertcode.app.product.models.entity.Product;

public interface ProductService {

	List<Product> findAll();
	
	Product findById(Long id);
	
}
