package com.allin.Allin.Service.Implement;

import com.allin.Allin.Entity.Enum.TokenType;
import com.allin.Allin.Entity.Token;
import com.allin.Allin.Entity.User;
import com.allin.Allin.Repository.TokenRepository;
import com.allin.Allin.Repository.UserRepository;
import com.allin.Allin.Service.AuthenticationService;
import com.allin.Allin.Service.JwtService;
import com.allin.Allin.dto.Request.RegisterRequest;
import com.allin.Allin.dto.Request.authenticationRequest;
import com.allin.Allin.dto.Response.AuthenticationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        String requestEmail = request.getEmail();
        List<User> userList = userRepository.findAllByStatusIsTrue();

        for (User user : userList) {
            if (user.getEmail().equals(requestEmail)) {
                // Email already exists, return an error response
                return AuthenticationResponse.builder()
                        .status("Error")
                        .message("Email already exists")
                        .build();
            }
        }

        // If the loop completes without finding a matching email, proceed with user registration
        var newUser = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .status(true)
                .build();

        var savedUser = userRepository.save(newUser);
        var jwtToken = jwtService.generateToken(newUser);
        var refreshToken = jwtService.generateRefreshToken(newUser);
        saveUserToken(savedUser, jwtToken);

        return AuthenticationResponse.builder()
                .status("Success")
                .message("User registered successfully")
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }
    private void revokeAllUserTokens(User user){
        var validToken = tokenRepository.findAllValidTokensByUser(user.getUserId());
        if (validToken.isEmpty()){
            return;
        }
        validToken.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validToken);
    }

    @Override
    public AuthenticationResponse authenticate(authenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();

    }

    @Override
    public void refreshToken(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String userEmail;
        final String refreshToken;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {

            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUserName(refreshToken);
        if (userEmail != null ){
            var userDetails = this.userRepository.findByEmail(userEmail).orElseThrow();
            if (jwtService.isTokenValid(refreshToken, userDetails)) {
                var accToken = jwtService.generateToken(userDetails);
                revokeAllUserTokens(userDetails);
                saveUserToken(userDetails, accToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
