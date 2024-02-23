package com.NQH.Jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.NQH.Entity.CustomUserDetail;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class JwtTokenProvider {
	
	private final String JWT_SECRET = "NQH";
	
	private final long JWT_EXPIRATION = 6000000L;
	
	//Taoj jwt tuwf user:
	public String generateToken(CustomUserDetail userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                   .setSubject(Long.toString(userDetails.getUser().getId()))
                   .setIssuedAt(now)
                   .setExpiration(expiryDate)
                   .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                   .compact();
    }
	
	public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(JWT_SECRET)
                            .parseClaimsJws(token)
                            .getBody();

        return Long.parseLong(claims.getSubject());
    }
	
	 public boolean validateToken(String authToken) {
	        try {
	            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
	            return true;
	        } catch (MalformedJwtException ex) {
	            log.error("Invalid JWT token");
	        } catch (SignatureException ex) {
	            log.error("Expired JWT token");
	        } catch (UnsupportedJwtException ex) {
	            log.error("Unsupported JWT token");
	        } catch (IllegalArgumentException ex) {
	            log.error("JWT claims string is empty.");
	        }
	        return false;
	    }

}
