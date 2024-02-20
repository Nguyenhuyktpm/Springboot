/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Security.API;

import ch.qos.logback.core.model.Model;
import com.example.Security.Entity.UserEntity;
import com.example.Security.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserAPI {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("HelloException");
    }
     
    @GetMapping("/user/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<UserEntity> getUser(@PathVariable("id") Long id) {
        UserEntity user = userService.getUser(id);
        return ResponseEntity.ok().body(user);
    }
    
    @GetMapping("/{id}")
    public Long GetID(@PathVariable("id") Long id) {
        return id;
    }
    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<UserEntity>> getAllUser() {
        List<UserEntity> allUser = userService.getAllUser();
        return ResponseEntity.ok().body(allUser);
    }
    
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
}
