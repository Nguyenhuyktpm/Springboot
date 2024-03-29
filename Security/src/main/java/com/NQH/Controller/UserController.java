package com.NQH.Controller;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.NQH.Entity.CustomUserDetail;
import com.NQH.Entity.UserEntity;
import com.NQH.Jwt.JwtTokenProvider;
import com.NQH.Payload.LoginRequest;
import com.NQH.Payload.LoginResponse;
import com.NQH.Service.UserMananagerService;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserMananagerService userManagerService;
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
	
	 @GetMapping("user")
	 public List<UserEntity> user(){
		 
		 return userManagerService.getAllUser();
	 }
}
