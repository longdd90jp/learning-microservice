package com.mathtrainer.backed.auth.service.impl;

import com.mathtrainer.backed.auth.api.dto.LoginRequest;
import com.mathtrainer.backed.auth.api.dto.LoginResponse;
import com.mathtrainer.backed.auth.api.dto.UserRegisterRequest;
import com.mathtrainer.backed.auth.api.dto.UserRegisterResponse;
import com.mathtrainer.backed.auth.domain.User;
import com.mathtrainer.backed.auth.repository.UserRepository;
import com.mathtrainer.backed.auth.service.AuthService;
import com.mathtrainer.backed.common.dto.JWTPayloadDto;
import com.mathtrainer.backed.common.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserRegisterResponse registerUser(UserRegisterRequest registerRequest) {
        UserRegisterResponse registerResponse = new UserRegisterResponse();

        // check username is exist
        Optional<User> existUser = userRepository.findFirstByUsername(registerRequest.getUsername());
        if(existUser.isPresent()) {
            registerResponse.setError(true);
            registerResponse.setMessage("username is exist");
            return registerResponse;
        }

        // register user
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);

        registerResponse.setMessage("register done");
        return registerResponse;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        Optional<User> userOptional = userRepository.findFirstByUsername(loginRequest.getUsername());

        if(!userOptional.isPresent() || !passwordEncoder.matches(loginRequest.getPassword(), userOptional.get().getPassword())) {
            // login fail
            loginResponse.setMessage("invalid login info");
            loginResponse.setError(true);
        } else {
            // genarate jwt token if log successful
            User user = userOptional.get();
            JWTPayloadDto payloadDto = new JWTPayloadDto();
            payloadDto.setUsername(user.getUsername());
            payloadDto.setUserId(user.getId());
            loginResponse.setAccessToken(JwtTokenUtil.generateToken(payloadDto));
        }
        return loginResponse;
    }
}
