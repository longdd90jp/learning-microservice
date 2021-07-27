package com.mathtrainer.backed.gamification.repository;

import com.mathtrainer.backed.gamification.domain.BadgeCard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BadgeCardRepository extends MongoRepository<BadgeCard, String> {

    /**
     * Retrieves all BadgeCards for a given user.
     * @param userId the id of the user to look for BadgeCards
     * @return the list of BadgeCards, sorted by most recent.
     */
    List<BadgeCard> findByUserIdOrderByBadgeTimestampDesc(final String userId);

}
