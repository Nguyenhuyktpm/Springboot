package com.NQH.Service.Impliments;

import java.util.List;

import org.springframework.stereotype.Service;

import com.NQH.Entity.UserEntity;
import com.NQH.Repository.UserRepository;
import com.NQH.Service.UserMananagerService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class UserManagerServiceImpl implements UserMananagerService {
	private final UserRepository userRepository;
	@Override
	public List<UserEntity> getAllUser() {
		
		return userRepository.findAll();
	}
}
