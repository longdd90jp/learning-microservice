package com.mathtrainer.backed.calculator.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("multiplication_result_attempts")
public class MultiplicationResultAttempt extends BaseResultAttempt {

    private Multiplication multiplication;

    // Empty constructor for JSON/JPA
    public MultiplicationResultAttempt() {
        super();
        multiplication = null;
    }

}
