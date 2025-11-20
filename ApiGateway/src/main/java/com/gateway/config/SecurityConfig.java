package com.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;*/

@Configuration
//@EnableWebFluxSecurity
public class SecurityConfig {

	/*
	 * @Bean public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity
	 * httpSecurity) {
	 * 
	 * httpSecurity.authorizeExchange() .anyExchange()
	 * .authenticated().and().oauth2Client().and().oauth2ResourceServer().jwt();
	 * return httpSecurity.build();
	 * 
	 * 
	 * httpSecurity. authorizeExchange(exchanges -> exchanges
	 * .pathMatchers("/auth/**").permitAll() // Allow auth endpoints
	 * .anyExchange().authenticated() // Secure all other routes
	 * ).oauth2ResourceServer().jwt(); // JWT validation
	 * 
	 * return httpSecurity.build(); }
	 */

	@Bean
	public Logger logger() {
		return LoggerFactory.getLogger("SecurityLogger");
	}
}
