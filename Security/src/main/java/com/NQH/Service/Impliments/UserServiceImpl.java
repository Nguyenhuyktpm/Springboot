package com.NQH.Service.Impliments;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.NQH.Entity.CustomUserDetail;
import com.NQH.Entity.UserEntity;
import com.NQH.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserDetailsService{
	private final UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
		
		return new CustomUserDetail(user);
	}
	public UserDetails loadUserById(Long userId) {
		UserEntity  user = userRepository.findById(userId).get();
		
		return new CustomUserDetail(user);
	}
}
