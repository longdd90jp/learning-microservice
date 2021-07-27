package com.mathtrainer.backed.gamification.repository.impl;

import com.mathtrainer.backed.gamification.domain.LeaderBoardRow;
import com.mathtrainer.backed.gamification.domain.ScoreCard;
import com.mathtrainer.backed.gamification.repository.custom.CustomScoreCardRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.List;

public class ScoreCardRepositoryImpl implements CustomScoreCardRepository {

    private final MongoTemplate mongoTemplate;

    private static final String USER_ID = "userId";
    private static final String SCORE = "score";
    private static final String TOTAL_SCORE = "totalScore";

    @Autowired
    public ScoreCardRepositoryImpl(
            MongoTemplate mongoTemplate
    ) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public int getTotalScoreForUser(String userId) {
        MatchOperation matchUserId = Aggregation.match(new Criteria(USER_ID).is(userId));
        GroupOperation groupByScore = Aggregation.group(USER_ID).sum(SCORE).as(TOTAL_SCORE);
        Aggregation aggregation = Aggregation.newAggregation(matchUserId, groupByScore);

        // run aggregation
        AggregationResults<UserScore> results = mongoTemplate.aggregate(aggregation, ScoreCard.class, UserScore.class);
        List<UserScore> userScores = results.getMappedResults();
        if(userScores.size() > 0) {
            return userScores.get(0).getTotalScore();
        } else {
            return 0;
        }
    }

    @Override
    public List<LeaderBoardRow> findFirstTop(int topRange) {
        GroupOperation groupByScore = Aggregation.group(USER_ID).sum(SCORE).as(TOTAL_SCORE);
        SortOperation sortByScore = Aggregation.sort(Sort.Direction.DESC, TOTAL_SCORE);
        LimitOperation limitByTopRange = Aggregation.limit(topRange);
        Aggregation aggregation = Aggregation.newAggregation(groupByScore, sortByScore, limitByTopRange);

        // run aggregation
        AggregationResults<UserScore> results = mongoTemplate.aggregate(aggregation, ScoreCard.class, UserScore.class);
        List<LeaderBoardRow> leaderBoardRows = new ArrayList<>();
        results.getMappedResults().forEach(userScore -> {
            leaderBoardRows.add(new LeaderBoardRow(userScore.get_id(), Long.valueOf(userScore.getTotalScore())));
        });
        return leaderBoardRows;
    }

    @Data
    class UserScore {
        private String _id;
        private int totalScore;
    }
}
