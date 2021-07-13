package com.bidyut.springbootkafkademoconsumer.dto;

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
	@Override
	public String toString() {
		return "UserDTO [Name=" + Name + ", message=" + message + "]";
	}

	

}
