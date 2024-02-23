package com.NQH.Controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.NQH.Entity.CustomUserDetail;
import com.NQH.Jwt.JwtTokenProvider;
import com.NQH.Payload.LoginRequest;
import com.NQH.Payload.LoginResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider tokenProvider;
	
	@PostMapping("login")
	public LoginResponse authenticateUser( @RequestBody LoginRequest loginRequest) {
		
		

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetail) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }
	
	
}
