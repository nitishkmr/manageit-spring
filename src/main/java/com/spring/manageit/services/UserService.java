package com.spring.manageit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.manageit.domain.User;
import com.spring.manageit.exceptions.UsernameAlreadyExistsException;
import com.spring.manageit.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User saveUser(User newUser) {
		
		try {
			newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			
			// Unique Username
			newUser.setUsername(newUser.getUsername());
			
			// Password and password2 should match
			return userRepository.save(newUser);
			
		} catch (Exception e) {
			throw new UsernameAlreadyExistsException("Username '"+newUser.getUsername()+"' already exists");
		}
	}
}
