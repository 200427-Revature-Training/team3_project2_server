package com.team3.security;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);
	
	/*
	 * public void commence(HttpServletRequest httpServletRequest,
	 * HttpServletResponse httpServletResponse, AuthenticationException e) throws
	 * IOException, ServletException {
	 * logger.error("Responding with unauthorized error. Message - {}",
	 * e.getMessage());
	 * httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
	 * e.getMessage());
	 * 
	 * }
	 */

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException authException)
			throws IOException, ServletException {
		logger.error("Responding with unauthorized error. Message - {}", authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
		
	}
}
