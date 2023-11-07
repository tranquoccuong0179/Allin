package com.allin.Allin.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


public interface JwtService {
     String extractUserName(String jwt);
     boolean isTokenValid(String token, UserDetails userDetails);
      String generateToken(UserDetails userDetails);
}
