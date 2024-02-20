/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.example.Security.Config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.testng.Assert.*;

/**
 *
 * @author nqhkt
 */
public class SecurityConfigNGTest {
    
    public SecurityConfigNGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of passwordEncoder method, of class SecurityConfig.
     */
    @org.testng.annotations.Test
    public void testPasswordEncoder() {
        System.out.println("passwordEncoder");
        SecurityConfig instance = new SecurityConfig();
        PasswordEncoder expResult = null;
        PasswordEncoder result = instance.passwordEncoder();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of securityFilterChain method, of class SecurityConfig.
     */
    @org.testng.annotations.Test
    public void testSecurityFilterChain() throws Exception {
        System.out.println("securityFilterChain");
        HttpSecurity http = null;
        SecurityConfig instance = new SecurityConfig();
        SecurityFilterChain expResult = null;
        SecurityFilterChain result = instance.securityFilterChain(http);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
