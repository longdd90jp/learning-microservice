package com.mathtrainer.backed.calculator.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BaseResultAttempt {

    @Id
    private String id;

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
