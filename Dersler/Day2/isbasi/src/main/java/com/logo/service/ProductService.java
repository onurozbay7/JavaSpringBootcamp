package com.logo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class ProductService {

	public String url = "default url";
	public String username = "default username";
	public String password = "default password";

	public ProductService() {
		super();
	}

	public ProductService(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}

}
