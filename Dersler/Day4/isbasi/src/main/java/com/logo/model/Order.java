package com.logo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private LocalDateTime createdDate = LocalDateTime.now();
	private List<Product> productList = new ArrayList<>();

	public Order(List<Product> productList) {
		this.productList = productList;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
