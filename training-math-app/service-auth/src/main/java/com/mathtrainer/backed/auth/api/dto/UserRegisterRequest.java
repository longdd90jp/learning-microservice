package com.mathtrainer.backed.auth.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
