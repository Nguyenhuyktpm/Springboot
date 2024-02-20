/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Security.Service;


import com.example.Security.Entity.UserEntity;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author nqhkt
 */

public interface UserService {
    UserEntity getUser(Long id);
    List<UserEntity> getAllUser();
    
      
}
