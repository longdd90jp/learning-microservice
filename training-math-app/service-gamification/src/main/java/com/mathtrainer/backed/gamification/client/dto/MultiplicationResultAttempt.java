package com.mathtrainer.backed.gamification.client.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mathtrainer.backed.gamification.client.MultiplicationResultAttemptDeserializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@JsonDeserialize(using = MultiplicationResultAttemptDeserializer.class)
public final class MultiplicationResultAttempt {

    private final String userId;

    private final int multiplicationFactorA;
    private final int multiplicationFactorB;
    private final int resultAttempt;

    private final boolean correct;

    // Empty constructor for JSON/JPA
    public MultiplicationResultAttempt() {
        this.userId = null;
        this.multiplicationFactorA = -1;
        this.multiplicationFactorB = -1;
        this.resultAttempt = -1;
        this.correct = false;
    }
}
