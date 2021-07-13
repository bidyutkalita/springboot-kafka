package com.bidyut.springbootkafkademo.dto;

public class UserDTO {
	private String Name;
	private String message;
	
	public UserDTO() {
	}
	public UserDTO(String name, String message) {
		super();
		Name = name;
		this.message = message;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	

}
