/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.Security.Config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author nqhkt
 */
public class SecurityConfigTest {
    
    public SecurityConfigTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of passwordEncoder method, of class SecurityConfig.
     */
    @Test
    public void testPasswordEncoder() {
        System.out.println("passwordEncoder");
        SecurityConfig instance = new SecurityConfig();
        PasswordEncoder expResult = null;
        PasswordEncoder result = instance.passwordEncoder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of securityFilterChain method, of class SecurityConfig.
     */
    @Test
    public void testSecurityFilterChain() throws Exception {
        System.out.println("securityFilterChain");
        HttpSecurity http = null;
        SecurityConfig instance = new SecurityConfig();
        SecurityFilterChain expResult = null;
        SecurityFilterChain result = instance.securityFilterChain(http);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
