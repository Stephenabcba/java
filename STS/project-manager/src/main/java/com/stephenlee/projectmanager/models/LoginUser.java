package com.stephenlee.projectmanager.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
    @NotEmpty(message = "Email must not be blank")
    @Email(message = "Email must be in valid format")
    private String email;
    
    @NotEmpty(message = "Password must not be blank")
    @Size(min=8,message = "Password must be at lease 8 characters long")
    private String password;

	public LoginUser() {}

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
}