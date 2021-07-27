package com.mathtrainer.backed.gamification.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class GameStatus {

    private String userId;
    private int score;
    private List<Badge> badges;

    // Empty constructor for JSON / JPA
    public GameStatus() {
        this.userId = "";
        this.score = 0;
        this.badges = new ArrayList<>();
    }

    public GameStatus(String userId, int score, List<Badge> badges) {
        this.userId = userId;
        this.score = score;
        this.badges = badges;
    }

    /**
     * Factory method to build an empty instance (zero points and no badges)
     * @param userId the user's id
     * @return a {@link GameStatus} object with zero score and no badges
     */
    public static GameStatus emptyStatus(final String userId) {
        GameStatus gameStatus = new GameStatus();
        gameStatus.userId = userId;
        return gameStatus;
    }

    /**
     * @return an unmodifiable view of the badge cards list
     */
    public List<Badge> getBadges() {
        return Collections.unmodifiableList(badges);
    }
}
