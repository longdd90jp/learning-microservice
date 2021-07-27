package com.mathtrainer.backed.gamification.service;

import com.mathtrainer.backed.gamification.domain.LeaderBoardRow;

import java.util.List;

/**
 * Provides methods to access the LeaderBoard with users and scores.
 */
public interface LeaderBoardService {

    /**
     * Retrieves the current leader board with the top score users
     *
     * @param topRange top value. ex: top 5, top 10
     * @return the users with the highest score
     */
    List<LeaderBoardRow> getCurrentLeaderBoard(int topRange);
}
