/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Hell.converter;


import com.example.Hell.dto.UserDTO;
import com.example.Hell.entity.UserEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author nqhkt
 */
@Component
public class UserConverter {
    public UserEntity toEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setUserName(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setFullName(dto.getFullname());
        entity.setStatus(dto.getStatus());
        
        return entity;
    }
    
     public UserDTO toDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setFullname(entity.getFullName());
        dto.setUsername(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
