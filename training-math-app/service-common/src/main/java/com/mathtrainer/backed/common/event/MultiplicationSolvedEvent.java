package com.mathtrainer.backed.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiplicationSolvedEvent implements Serializable {

    private String multiplicationResultAttemptId;
    private String userId;
    private boolean correct;
}