package com.spring.manageit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.spring.manageit.exceptions.InvalidLoginResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest arg0, HttpServletResponse httpServletResponse, AuthenticationException e)
			throws IOException, ServletException {
		
		InvalidLoginResponse loginResponse = new InvalidLoginResponse();
		String jsonLoginResponseString = new Gson().toJson(loginResponse);
		
		httpServletResponse.setContentType("application/json");
		httpServletResponse.setStatus(401);
		httpServletResponse.getWriter().print(jsonLoginResponseString);
		
		
	}
	
}
