package com.mathtrainer.backed.calculator.domain;

import lombok.Data;

@Data
public class BaseResultAttempt extends BaseDocument {

    private String userId;

    private int resultAttempt;

    private boolean correct;

    // Empty constructor for JSON/JPA
    public BaseResultAttempt() {
        userId = null;
        this.resultAttempt = -1;
        correct = false;
    }
}
