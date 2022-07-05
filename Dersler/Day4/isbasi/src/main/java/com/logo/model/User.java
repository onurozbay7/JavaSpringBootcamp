package com.logo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.logo.model.enums.FirmType;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String email;
	@Column
	private String password;
	@Enumerated(EnumType.ORDINAL)
	private FirmType firmType;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", insertable = true, updatable = false)
	private Address address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", insertable = true, updatable = false)
	private List<Customer> customerList = new ArrayList<>(10);

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public FirmType getFirmType() {
		return firmType;
	}

	public void setFirmType(FirmType firmType) {
		this.firmType = firmType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

}
