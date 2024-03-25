package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;

import com.example.demo.Jwt.JwtAuthenticationFilter;
import com.ons.securitylayerJwt.security.CustomerUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class Config {
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final CustomerUserDetailsService 
}
