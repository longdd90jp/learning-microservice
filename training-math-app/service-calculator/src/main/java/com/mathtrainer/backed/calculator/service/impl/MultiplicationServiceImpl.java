package com.mathtrainer.backed.calculator.service.impl;

import com.mathtrainer.backed.calculator.domain.Multiplication;
import com.mathtrainer.backed.calculator.domain.MultiplicationResultAttempt;
import com.mathtrainer.backed.calculator.event.EventDispatcher;
import com.mathtrainer.backed.calculator.repository.MultiplicationResultAttemptRepository;
import com.mathtrainer.backed.calculator.service.MultiplicationService;
import com.mathtrainer.backed.calculator.service.RandomGeneratorService;
import com.mathtrainer.backed.common.event.MultiplicationSolvedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;
    private MultiplicationResultAttemptRepository attemptRepository;
    private EventDispatcher eventDispatcher;

    @Autowired
    public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService,
                                     final MultiplicationResultAttemptRepository attemptRepository,
                                     final EventDispatcher eventDispatcher) {
        this.randomGeneratorService = randomGeneratorService;
        this.attemptRepository = attemptRepository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt attempt) {
        // Avoids 'hack' attempts
        Assert.isTrue(!attempt.isCorrect(), "You can't send an attempt marked as correct!!");

        Multiplication multiplication = attempt.getMultiplication();
        // Check if the attempt is correct
        boolean isCorrect = attempt.getResultAttempt() == (multiplication.getFactorA() * multiplication.getFactorB());

        MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt();
        checkedAttempt.setUserId(attempt.getUserId());
        checkedAttempt.setMultiplication(multiplication);
        checkedAttempt.setResultAttempt(attempt.getResultAttempt());
        checkedAttempt.setCorrect(isCorrect);

        // Stores the attempt
        attemptRepository.save(checkedAttempt);

        // Communicates the result via Event
        eventDispatcher.send(
                new MultiplicationSolvedEvent(checkedAttempt.getId(),
                        checkedAttempt.getUserId(),
                        checkedAttempt.isCorrect())
        );

        return isCorrect;
    }

    @Override
    public List<MultiplicationResultAttempt> getStatsForUser(String userId, int topRange) {
        return attemptRepository.findTopByUserId(userId, topRange);
    }

    @Override
    public MultiplicationResultAttempt getResultById(final String resultId) {
        return attemptRepository.findById(resultId).get();
    }
}
