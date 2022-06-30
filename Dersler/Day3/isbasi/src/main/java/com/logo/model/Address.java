package com.logo.model;

public class Address {

	private String country;
	private String province;
	private String address;

	public Address(String country, String province, String address) {
		super();
		this.country = country;
		this.province = province;
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
