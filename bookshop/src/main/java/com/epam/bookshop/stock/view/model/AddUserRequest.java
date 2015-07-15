package com.epam.bookshop.stock.view.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class AddUserRequest {
	
	//@NotNull
	//@Size(min = 1, max = 100)
	private String name;
	
	@NotNull
	@Email
	@Size(min = 1, max = 100)
	private String email;

	private Date birthdate;

	@NotNull
	@Size(min = 6, max = 12)
	private String password;

	@NotNull
	@Size(min = 6, max = 12)
	private String passwordConfirm;
	 
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
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
