package com.evertcode.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.evertcode.app.item.models.Item;
import com.evertcode.app.item.models.Product;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	
	private static final String URL_ENDPOINT = "http://product-service";

	@Autowired
	private RestTemplate  clientRest;
	
	@Override
	public List<Item> findAll() {
		
		List<Product> products = Arrays.asList(this.clientRest.getForObject(URL_ENDPOINT + "/list", Product[].class));
		
		return products.stream().map(product -> new Item(product, (int)(Math.random()*100))).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer count) {
		
		Map<String, String> params = new HashMap<>();
		params.put("id", id.toString());
		
		Product product = this.clientRest.getForObject(URL_ENDPOINT + "/detail/{id}", Product.class, params);
		
		return new Item(product, count);
	}

}
