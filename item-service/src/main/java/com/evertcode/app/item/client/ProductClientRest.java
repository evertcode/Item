package com.evertcode.app.item.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.evertcode.app.item.models.Product;

@FeignClient(name = "product-service")
public interface ProductClientRest {
	
	@GetMapping("/list")
	public List<Product> list();
	
	@GetMapping("/detail/{id}")
	public Product detail(@PathVariable Long id);
	
}
