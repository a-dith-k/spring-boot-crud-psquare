package com.adith.CrudApplication.repositories;

import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.adith.CrudApplication.entities.Admin;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	public AdminRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Optional<Admin> findAdminByUsername(String username) throws UsernameNotFoundException {
		String query="SELECT * FROM admin WHERE username=?";
	try {
		Admin admin= jdbcTemplate.queryForObject(query,new AdminRowMapper(),username);
		return Optional.of(admin);
	}catch(EmptyResultDataAccessException e) {
		throw new UsernameNotFoundException("User not Found");
	}catch(Exception e) {
		System.out.println("Message: "+e.getMessage());
		e.printStackTrace();
	}
			
	  
		return Optional.of(new Admin());
	}

	

}
