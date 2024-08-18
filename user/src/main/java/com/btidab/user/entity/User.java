package com.btidab.user.entity;

public class User {

	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String telephone;
	
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
	public String getFirstname() {
		return first_name;
	}
	public void setfirst_name(String firstname) {
		this.first_name = firstname;
	}
	public String getLastname() {
		return last_name;
	}
	public void setlast_name(String lastname) {
		this.last_name = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "user [username=" + username + ", password=" + password + ", Firstname=" + first_name + ", lastname="
				+ last_name + ", email=" + email + ", telephone=" + telephone + "]";
	}
	
	
	
}
