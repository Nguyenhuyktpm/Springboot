package com.NQH.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.NQH.Entity.UserEntity;



@Service
public interface UserMananagerService {
	 List<UserEntity> getAllUser();
		
	
}
