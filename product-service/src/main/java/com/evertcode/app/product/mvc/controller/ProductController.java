package com.evertcode.app.product.mvc.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evertcode.app.product.models.entity.Product;
import com.evertcode.app.product.models.service.ProductService;

@RestController
public class ProductController {
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public List<Product> list(){
		return this.productService.findAll().stream().map(product -> {
			
			product.setPort(port);
			
			return product;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/detail/{id}")
	public Product detail(@PathVariable Long id) throws Exception {
		
		Product product = this.productService.findById(id);
		
		product.setPort(port);
		
		//Thread.sleep(2000L);
		
		return product;
	}
	
}
