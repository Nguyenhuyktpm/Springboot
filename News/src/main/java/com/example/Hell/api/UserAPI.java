/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Hell.api;

import com.example.Hell.dto.UserDTO;
import com.example.Hell.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAPI {
    @Autowired
    private IUserService userService;
    @PostMapping(value = "/user")
    public UserDTO createUser(@RequestBody UserDTO model)
    {
        return userService.save(model); 
    }
}
