/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Security.Service.ServiceImplement;

import com.example.Security.Entity.UserEntity;
import com.example.Security.Repository.UserRepository;
import com.example.Security.Service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nqhkt
 */
@Service
public class IUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUser(Long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        return optionalUser.get();

    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }
}
