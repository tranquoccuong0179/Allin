package com.allin.Allin.Controller;

import com.allin.Allin.Service.AuthenticationService;
import com.allin.Allin.dto.Request.RegisterRequest;
import com.allin.Allin.dto.Request.authenticationRequest;
import com.allin.Allin.dto.Response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
@PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> Register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> Register(
            @RequestBody authenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
