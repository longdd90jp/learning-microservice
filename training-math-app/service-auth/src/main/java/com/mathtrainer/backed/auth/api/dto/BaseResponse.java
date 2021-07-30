package com.mathtrainer.backed.auth.api.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BaseResponse {

    private boolean isError = false;
    private String message;

    public HttpStatus getHttpStatus() {
        if(isError) return HttpStatus.BAD_REQUEST;
        return HttpStatus.OK;
    }

    private HttpStatus httpStatus;
}
