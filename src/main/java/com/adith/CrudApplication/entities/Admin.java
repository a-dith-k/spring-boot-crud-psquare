package com.adith.CrudApplication.entities;

public class Admin {
	
	
	public Admin(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public Admin() {
		
	}



	private Integer id;
	private String username;
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	

}
