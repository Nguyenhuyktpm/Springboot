/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Hell.service.impl;

import com.example.Hell.converter.UserConverter;
import com.example.Hell.dto.UserDTO;
import com.example.Hell.entity.RoleEntity;
import com.example.Hell.entity.UserEntity;
import com.example.Hell.repository.RoleRepository;
import com.example.Hell.repository.UserRepository;
import com.example.Hell.service.IUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nqhkt
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserEntity userEntity = userConverter.toEntity(userDTO);
        RoleEntity roleEntity = roleRepository.findOneByCode(userDTO.getRoleid());
        List<RoleEntity> listRoleEntity = new ArrayList<>();
        listRoleEntity.add(roleEntity);
        userEntity.setRoles(listRoleEntity);
        userEntity = userRepository.save(userEntity);
        return userConverter.toDTO(userEntity);
    }
    
    
    
}
