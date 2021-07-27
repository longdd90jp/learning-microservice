package com.mathtrainer.backed.calculator.repository;

import com.mathtrainer.backed.calculator.domain.Multiplication;
import com.mathtrainer.backed.calculator.domain.MultiplicationResultAttempt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MultiplicationResultAttemptRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultiplicationResultAttemptRepositoryTest.class);

    @Autowired
    private MultiplicationResultAttemptRepository resultAttemptRepository;

    @Test
    public void doTest() {
        MultiplicationResultAttempt resultAttempt = new MultiplicationResultAttempt();
        resultAttempt.setResultAttempt(1);
        resultAttempt.setCorrect(true);
        MultiplicationResultAttempt savedObj = resultAttemptRepository.save(resultAttempt);
        LOGGER.info(savedObj.getId());
    }
}
