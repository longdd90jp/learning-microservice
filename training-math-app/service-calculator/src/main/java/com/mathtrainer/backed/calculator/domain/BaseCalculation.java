package com.mathtrainer.backed.calculator.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BaseCalculation {

    @Id
    private String id;
}
