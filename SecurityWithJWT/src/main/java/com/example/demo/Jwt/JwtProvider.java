package com.example.demo.Jwt;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class JwtProvider {
	@Value("${jwt.secret}")
	private String secret; 
	@Value("${jwt.expiration}")
	private Long jwtExpiration;
	 //lấy username từ Sublect
	 public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }
	 
	 //lấy ra các claim
	 public Claims extractAllClaims(String token) {return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();}
	
	 //Lấy claim cụ thể từ thằng trên
	 public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	 //lấy ra thời gian hết hạn của 1 token
	 public Date extractExpiration(String token) { return extractClaim(token, Claims::getExpiration); }
	 
	 
	 //Kiểm tra username trong token có giống với userDetails hay không, token còn hạn không
	  public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	        
	        
	    }
	  // kiểm tra token hết hạn chưa
	  //
	  public Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }
	  
	  //Tạo ra token
	  public String generateToken(String username , List<String> roles) {

	        return Jwts.builder().setSubject(username).claim("role",roles).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(Date.from(Instant.now().plus(jwtExpiration, ChronoUnit.MILLIS)))
	                .signWith(SignatureAlgorithm.HS256, secret).compact();
	    }
	  
	  public boolean validateToken(String token) {
	        try {
	            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
	            return true;
	        } catch (SignatureException e) {
	            log.info("Invalid JWT signature.");
	            log.trace("Invalid JWT signature trace: {}", e);
	        } catch (MalformedJwtException e) {
	            log.info("Invalid JWT token.");
	            log.trace("Invalid JWT token trace: {}", e);
	        } catch (ExpiredJwtException e) {
	            log.info("Expired JWT token.");
	            log.trace("Expired JWT token trace: {}", e);
	        } catch (UnsupportedJwtException e) {
	            log.info("Unsupported JWT token.");
	            log.trace("Unsupported JWT token trace: {}", e);
	        } catch (IllegalArgumentException e) {
	            log.info("JWT token compact of handler are invalid.");
	            log.trace("JWT token compact of handler are invalid trace: {}", e);
	        }
	        return false;
	  }
	  public String getToken (HttpServletRequest httpServletRequest) {
	         final String bearerToken = httpServletRequest.getHeader("Authorization");
	         if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
	         {return bearerToken.substring(7,bearerToken.length()); } // The part after "Bearer "
	         return null;
	    }

}
