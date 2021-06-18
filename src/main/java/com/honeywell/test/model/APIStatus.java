package com.honeywell.test.model;

public enum APIStatus {
	SUCCESS("success"), ERROR("error");

	private String value;

	APIStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	};
}
