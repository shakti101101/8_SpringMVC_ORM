package com.springmvc.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Serversidevalidation {

	@NotBlank (message ="User Name can not be blank !!")
	private String username;
	@Size(min = 3, max =12, message = "password can not be blank")
	@NotBlank
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Serversidevalidation [username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
	
}
