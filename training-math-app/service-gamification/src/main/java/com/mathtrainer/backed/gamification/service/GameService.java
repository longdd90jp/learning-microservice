package com.mathtrainer.backed.gamification.service;

import com.mathtrainer.backed.gamification.domain.GameStatus;

/**
 * This service includes the main logic for gamifying the system.
 */
public interface GameService {

    /**
     * Process a new attempt from a given user.
     *
     * @param userId    the user's unique id
     * @param attemptId the attempt id, can be used to retrieve extra data if needed
     * @param correct   indicates if the attempt was correct
     *
     * @return a {@link GameStatus} object containing the new score and badge cards obtained
     */
    GameStatus newAttemptForUser(String userId, String attemptId, boolean correct);

    /**
     * Gets the game statistics for a given user
     * @param userId the user
     * @return the total statistics for that user
     */
    GameStatus retrieveStatusForUser(String userId);
}
