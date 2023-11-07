package com.allin.Allin.Service;

import com.allin.Allin.dto.Request.RegisterRequest;
import com.allin.Allin.dto.Request.authenticationRequest;
import com.allin.Allin.dto.Response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(authenticationRequest request);
}
