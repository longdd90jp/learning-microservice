package com.mathtrainer.backed.calculator.repository;

import com.mathtrainer.backed.calculator.domain.Multiplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MultiplicationRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultiplicationRepositoryTest.class);

    @Autowired
    private MultiplicationRepository multiplicationRepository;

    @Test
    public void doTest() {
        Multiplication multiplication = new Multiplication(1,2);
        Multiplication savedObj = multiplicationRepository.save(multiplication);
        LOGGER.info(savedObj.getId());
    }
}
