package com.mathtrainer.backed.gamification.repository;

import com.mathtrainer.backed.gamification.domain.ScoreCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreCardRepositoryTest {

    @Autowired
    private ScoreCardRepository scoreCardRepository;

    @Test
    public void doTest() {
        int totalScore = scoreCardRepository.getTotalScoreForUser("user_1");
        System.out.println(totalScore);

        List<ScoreCard> scoreCards = scoreCardRepository.findByUserIdOrderByScoreTimestampDesc("user_1");
        System.out.println(scoreCards.size());

        System.out.println(scoreCardRepository.findFirstTop(10));
    }
}
