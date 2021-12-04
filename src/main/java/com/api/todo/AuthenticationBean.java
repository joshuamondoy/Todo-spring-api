package com.api.todo;

public class AuthenticationBean {
	private String message;

	public AuthenticationBean() {
		// no args
	}
	public AuthenticationBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
