package com.mathtrainer.backed.common.dto;

import lombok.Data;

@Data
public class JWTPayloadDto {

    private String userId;
    private String username;
    private long iat;
    private long exp;
}
