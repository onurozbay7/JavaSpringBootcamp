package com.logo.dto;

public class EmailDto {

	private String to;
	private String title;
	private String email;

	public EmailDto(String to, String title, String email) {
		super();
		this.to = to;
		this.title = title;
		this.email = email;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
