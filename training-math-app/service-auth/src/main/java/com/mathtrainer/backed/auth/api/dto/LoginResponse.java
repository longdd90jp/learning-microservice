package com.mathtrainer.backed.auth.api.dto;

import lombok.Data;

@Data
public class LoginResponse extends BaseResponse{

    private String accessToken;
    private String tokenType = "Bearer";
}

