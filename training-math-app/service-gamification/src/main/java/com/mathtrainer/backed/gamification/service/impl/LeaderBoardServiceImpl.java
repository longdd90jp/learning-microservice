package com.mathtrainer.backed.gamification.service.impl;

import com.mathtrainer.backed.gamification.domain.LeaderBoardRow;
import com.mathtrainer.backed.gamification.repository.ScoreCardRepository;
import com.mathtrainer.backed.gamification.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class LeaderBoardServiceImpl implements LeaderBoardService {

    private final ScoreCardRepository scoreCardRepository;

    @Autowired
    public LeaderBoardServiceImpl(
            ScoreCardRepository scoreCardRepository
    ) {
        this.scoreCardRepository = scoreCardRepository;
    }

    @Override
    public List<LeaderBoardRow> getCurrentLeaderBoard(int topRange) {
        return scoreCardRepository.findFirstTop(topRange);
    }
}
