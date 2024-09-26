package com.chaitanya.rest.webservices.restful_web_services.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.web.SecurityFilterChain;

//import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

////		1) All requests should be authenticated
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
////		2) If a request is not authenticated, use http basic
		http.httpBasic(withDefaults());
//
////		3) CSRF -> POST, PUT
		http.csrf(csrf -> csrf.disable());
		// OR
		http.csrf(AbstractHttpConfigurer::disable);
//
//
		return http.build();
	}

}