package com.evertcode.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertcode.app.item.client.ProductClientRest;
import com.evertcode.app.item.models.Item;

@Service("itemServiceFeign")
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductClientRest clientFeing;
	
	@Override
	public List<Item> findAll() {
		return this.clientFeing.list().stream().map(product -> new Item(product, (int)(Math.random()*100))).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer count) {
		return new Item(this.clientFeing.detail(id), count);
	}

}
