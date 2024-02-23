package com.NQH.Payload;

import lombok.Data;




@Data
public class LoginRequest {
    
    private String username;
   
    private String password;
}
