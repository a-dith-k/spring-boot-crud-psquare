package com.adith.CrudApplication.repositories;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.adith.CrudApplication.entities.Admin;

@Repository
public interface AdminRepository {
	
	Optional<Admin> findAdminByUsername(String username) throws UsernameNotFoundException;

}
