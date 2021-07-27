package com.mathtrainer.backed.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("multiplications")
@AllArgsConstructor
public class Multiplication extends BaseCalculation{

    // Both factors
    private int factorA;
    private int factorB;

    // Empty constructor for JSON/JPA
    public Multiplication() {
        this.factorA = 0;
        this.factorB = 0;
    }
}
