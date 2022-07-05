package com.logo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.logo.model.enums.CustomerTpe;

import lombok.Builder;

@Entity
@Builder
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private int age;
	@Enumerated(EnumType.ORDINAL)
	private CustomerTpe customerType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public CustomerTpe getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerTpe customerType) {
		this.customerType = customerType;
	}

}
