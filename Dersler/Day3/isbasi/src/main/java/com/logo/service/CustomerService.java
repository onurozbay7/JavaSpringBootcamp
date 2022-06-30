package com.logo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.logo.model.Customer;
import com.logo.model.Order;
import com.logo.model.Product;

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
		Customer customer = new Customer(name, 25, new ArrayList<>());

		System.out.println("orderService:" + orderService.toString());
		// orderService.createOrder();

		System.out.println("productService:" + productService.toString());

		return customer;
	}

	private List<Customer> prepareCustomerList() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("bilisim.io", 25, new ArrayList<>()));
		customers.add(new Customer("cem", 30, prepareOrderList()));
		customers.add(new Customer("ömer", 21, prepareOrderList()));
		customers.add(new Customer("haluk", 32, prepareOrderList()));
		customers.add(new Customer("halil", 25, prepareOrderList()));
		customers.add(new Customer("fatih", 18, prepareOrderList()));
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
