package com.epam.bookshop.stock.view.model;

import com.epam.bookshop.user.domain.UserDateFormat;

public class AddUserRequest {
	 private String name;
	 private String email;
	 private String password;
	 private UserDateFormat birthdate;
	 private String passwordConfirm;
	 
	public UserDateFormat getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(UserDateFormat birthdate) {
		this.birthdate = birthdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
}
