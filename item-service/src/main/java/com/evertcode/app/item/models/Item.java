package com.evertcode.app.item.models;

import java.io.Serializable;

public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1766372243170760955L;

	private Product product;
	
	private Integer count;
	
	public Item() {}
	
	public Item(Product product, Integer count) {
		this.product = product;
		this.count = count;
	}
	

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public Double getTotal() {
		return this.product.getPrice() * this.count.doubleValue();
	}
	
}
