package com.mathtrainer.backed.auth.api.controller;

import com.mathtrainer.backed.auth.api.dto.LoginRequest;
import com.mathtrainer.backed.auth.api.dto.LoginResponse;
import com.mathtrainer.backed.auth.api.dto.UserRegisterRequest;
import com.mathtrainer.backed.auth.api.dto.UserRegisterResponse;
import com.mathtrainer.backed.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);
        return new ResponseEntity<>(loginResponse, loginResponse.getHttpStatus());
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterRequest registerRequest) {
        UserRegisterResponse registerResponse = authService.registerUser(registerRequest);
        return new ResponseEntity<>(registerResponse, registerResponse.getHttpStatus());
    }
}
