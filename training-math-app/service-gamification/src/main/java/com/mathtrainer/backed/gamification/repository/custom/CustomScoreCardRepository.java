package com.mathtrainer.backed.gamification.repository.custom;

import com.mathtrainer.backed.gamification.domain.LeaderBoardRow;

import java.util.List;

public interface CustomScoreCardRepository {
    /**
     * Gets the total score for a given user, being the sum of the scores of all his ScoreCards.
     * @param userId the id of the user for which the total score should be retrieved
     * @return the total score for the given user
     */
    int getTotalScoreForUser(final String userId);

    /**
     * Retrieves a list of {@link LeaderBoardRow}s representing the Leader Board of users and their total score.
     *
     * @param topRange top value. ex: top 5, top 10
     * @return the leader board, sorted by highest score first.
     */
    List<LeaderBoardRow> findFirstTop(int topRange);
}
