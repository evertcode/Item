package com.evertcode.app.product.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.evertcode.app.product.models.entity.Product;


public interface ProductDao extends CrudRepository<Product, Long>{

}
