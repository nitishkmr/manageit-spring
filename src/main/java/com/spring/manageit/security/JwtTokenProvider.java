package com.spring.manageit.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.spring.manageit.domain.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

	// Generate the token
	public String generateToken(Authentication authentication) {
		User user = (User)authentication.getPrincipal(); 
		Date now = new Date(System.currentTimeMillis());
		
		Date expiryDate = new Date(now.getTime() + SecurityConstants.EXPIRATION_TIME);
		
		String userId = Long.toString(user.getId());
		
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", Long.toString(user.getId()));
		claims.put("username", user.getUsername());
		claims.put("fullname", user.getFullName());
		
		return Jwts.builder()
				.setSubject(userId)
				.setClaims(claims)
				.setIssuedAt(expiryDate)
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
				.compact();
	}
	
	// Validate the token
	
	
	// Get user Id from the token
}
