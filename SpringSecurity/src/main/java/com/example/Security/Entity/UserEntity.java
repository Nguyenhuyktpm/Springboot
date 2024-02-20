/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Security.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author nqhkt
 */
@Getter
@Builder
@Entity

@Table(name = "User")
public class UserEntity extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "name")
    private String name; 
    
    
    public UserEntity() {
    }
    public UserEntity(String username,String password,String role,String name) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name=name;
    }
}
