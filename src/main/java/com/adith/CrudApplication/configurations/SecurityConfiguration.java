package com.adith.CrudApplication.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		  http.csrf(CsrfConfigurer::disable)
         .cors(CorsConfigurer::disable)
         .authorizeHttpRequests(authorize -> authorize
                 .requestMatchers("/").permitAll()
                 .anyRequest().authenticated()
         )
         .formLogin((form) -> form
                 .loginPage("/login").permitAll().
                 successForwardUrl("/students").
                 defaultSuccessUrl("/students"));
		  return http.build();
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService AdminDetailsService() {
	        return new AdminDetailsService();
	 }


    @Bean
    AuthenticationProvider authenticationProviderCustomer() {
    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(AdminDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(encoder());
        return daoAuthenticationProvider;
    }

}
