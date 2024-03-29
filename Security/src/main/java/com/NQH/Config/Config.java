package com.NQH.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.BeanIds;
import com.NQH.Jwt.JwtAuthenticationFilter;
import com.NQH.Jwt.JwtTokenProvider;
import com.NQH.Service.Impliments.UserServiceImpl;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {
	private final UserServiceImpl userServiceImpl;
	private final JwtTokenProvider tokenProvider;

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter(tokenProvider, userServiceImpl);
	}
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceImpl) // Cung cáp userservice cho spring security
				.passwordEncoder(passwordEncoder()); // cung cấp password encoder
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors() // Ngăn chặn request từ một domain khác
				.and()
			.csrf()
				.disable()
			.authorizeRequests().antMatchers("/login").permitAll() // Cho phép tất cả mọi người truy cập
																					// vào địa chỉ này
				.anyRequest().authenticated(); // Tất cả các request khác đều cần phải xác thực mới được truy cập

				// Thêm một lớp Filter kiểm tra jwt
		// http.addFilterBefore( jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
