	package com.adith.CrudApplication.configurations;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.adith.CrudApplication.entities.Admin;

public class AdminDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private final Admin admin;
	
	public AdminDetails(Admin admin) {
		this.admin=admin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return null;
	}

	@Override
	public String getPassword() {
	
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		return admin.getUsername();
	}

}
