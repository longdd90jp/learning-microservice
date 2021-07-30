package com.mathtrainer.backed.calculator.repository;

import com.mathtrainer.backed.calculator.domain.MultiplicationResultAttempt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultiplicationResultAttemptRepository extends MongoRepository<MultiplicationResultAttempt, String> {

    /**
     * @return the latest 5 attempts for a given user, identified by their alias.
     */
    List<MultiplicationResultAttempt> findTopByUserId(String userId, int topRange);
}
