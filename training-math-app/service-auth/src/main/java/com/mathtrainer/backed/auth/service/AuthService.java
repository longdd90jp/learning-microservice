package com.mathtrainer.backed.auth.service;

import com.mathtrainer.backed.auth.api.dto.LoginRequest;
import com.mathtrainer.backed.auth.api.dto.LoginResponse;
import com.mathtrainer.backed.auth.api.dto.UserRegisterRequest;
import com.mathtrainer.backed.auth.api.dto.UserRegisterResponse;

public interface AuthService {

    public UserRegisterResponse registerUser(UserRegisterRequest registerRequest);
    public LoginResponse login(LoginRequest loginRequest);
}
