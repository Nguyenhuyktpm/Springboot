/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Security.Entity.UserEntity;

/**
 *
 * @author nqhkt
 */

public interface UserRepository extends JpaRepository<UserEntity,Long>{
    UserEntity findByUsername(String username);
    UserEntity findByRole(String role);
}
