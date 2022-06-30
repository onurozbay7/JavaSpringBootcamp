package com.logo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class OrderService {

	@Autowired
	private ProductService productService;

	public void createOrder() {

		System.out.println("OrderService - productService:" + productService.toString());

		System.out.println("OrderService - productService:" + productService.url);

	}

}
