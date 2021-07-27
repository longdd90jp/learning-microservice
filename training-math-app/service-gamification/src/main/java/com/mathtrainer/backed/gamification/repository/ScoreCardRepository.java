package com.mathtrainer.backed.gamification.repository;

import com.mathtrainer.backed.gamification.domain.ScoreCard;
import com.mathtrainer.backed.gamification.repository.custom.CustomScoreCardRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreCardRepository extends MongoRepository<ScoreCard, String>, CustomScoreCardRepository {

    /**
     * Retrieves all the ScoreCards for a given user, identified by his user id.
     * @param userId the id of the user
     * @return a list containing all the ScoreCards for the given user, sorted by most recent.
     */
    List<ScoreCard> findByUserIdOrderByScoreTimestampDesc(String userId);
}
