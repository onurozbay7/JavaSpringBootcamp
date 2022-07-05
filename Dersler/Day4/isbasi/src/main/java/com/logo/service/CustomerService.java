package com.logo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.model.Customer;
import com.logo.model.Order;
import com.logo.model.Product;
import com.logo.model.enums.CustomerTpe;

@Service
public class CustomerService {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	public CustomerService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Customer create(String name) {
		Customer customer = Customer.builder().name("Cem").age(28).customerType(CustomerTpe.Customer).build();

		System.out.println("orderService:" + orderService.toString());

		System.out.println("productService:" + productService.toString());

		return customer;
	}

	private List<Customer> prepareCustomerList() {
		List<Customer> customers = new ArrayList<>();
		customers.add(Customer.builder().name("Cem").age(28).customerType(CustomerTpe.Customer).build());
		customers.add(Customer.builder().name("Emir").age(28).customerType(CustomerTpe.Customer).build());
		return customers;
	}

	private List<Order> prepareOrderList() {
		List<Order> orders = new ArrayList<>();
		int randomOrderNumber = new Random().nextInt(5);
		for (int i = 0; i < randomOrderNumber; i++) {
			Order order = new Order(prepareProductList(randomOrderNumber));
			orders.add(order);
		}
		return orders;
	}

	private List<Product> prepareProductList(int randomOrderNumber) {
		List<Product> products = new ArrayList<>();
		Random random = new Random();
		products.add(new Product("MacBook Pro", random.nextDouble(1000)));
		products.add(new Product("MacBook air", random.nextDouble(1000)));
		products.add(new Product("Mac Mini", random.nextDouble(1000)));
		products.add(new Product("iPhone 11", random.nextDouble(1000)));
		products.add(new Product("iPhone 12", random.nextDouble(1000)));

		return products.stream().limit(randomOrderNumber).toList();
	}

	public List<Customer> getAllCustomers() {

		// ProductService productService = new ProductService;
		// singleton olduğunun kanıtı
		System.out.println("CustomerService - productService:" + productService.toString());
		System.out.println("CustomerService - productService:" + productService.url);
		System.out.println("CustomerService - orderService:" + orderService.toString());

		orderService.createOrder();

		return prepareCustomerList();
	}

}
