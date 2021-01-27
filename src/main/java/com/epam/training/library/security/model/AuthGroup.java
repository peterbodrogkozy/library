package com.epam.training.library.security.model;

public enum AuthGroup {
	LIBRARIAN("LIBRARIAN"), USER("USER");
	
	private String value;
	
	private AuthGroup(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
