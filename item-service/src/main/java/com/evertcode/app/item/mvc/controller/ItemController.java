package com.evertcode.app.item.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evertcode.app.item.models.Item;
import com.evertcode.app.item.models.Product;
import com.evertcode.app.item.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ItemController {

	@Autowired
	@Qualifier("itemServiceFeign")
	//@Qualifier("itemService")
	private ItemService itemService;
	
	@GetMapping("/list")
	public List<Item> findAll(){
		return this.itemService.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "error")
	@GetMapping("/detail/{id}/count/{count}")
	public Item findById(@PathVariable Long id, @PathVariable Integer count) {
		return this.itemService.findById(id, count);
	}
	
	public Item error(Long id, Integer count) {
		
		final Item item = new Item();
		final Product product = new Product();
		
		product.setId(id);
		product.setName("Test faild");
		product.setPrice(234d);
		
		item.setCount(count);
		item.setProduct(product);
		
		return item;
	}
	
}
