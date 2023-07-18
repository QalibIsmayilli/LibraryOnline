package com.company.library.service;

import com.company.library.dto.TokenResponse;
import com.company.library.dto.requests.LoginRequest;
import com.company.library.exception.GenericException;
import com.company.library.util.TokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserService userService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserService userService, TokenGenerator tokenGenerator,
                       AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponse login(LoginRequest request){
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

            return new TokenResponse(tokenGenerator.generateToken(auth),
                    userService.findUserDtoByUsername(request.getUsername()));
        }catch (Exception ex){
            throw new GenericException(HttpStatus.NOT_FOUND,"User Not Found");
        }
    }
}
