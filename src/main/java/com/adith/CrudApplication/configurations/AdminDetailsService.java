package com.adith.CrudApplication.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.adith.CrudApplication.entities.Admin;
import com.adith.CrudApplication.repositories.AdminRepository;

public class AdminDetailsService implements UserDetailsService {
	
	@Autowired
	AdminRepository adminRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		//Admin admin=adminRepository.findAdminByUsername(username).orElseThrow(()->new UserNotFoundException("user not found"));
		Admin admin=adminRepository.findAdminByUsername(username).orElseThrow(()->new BadCredentialsException(username));
		
		return new AdminDetails(admin);
	}

}
