package com.mathtrainer.backed.gamification.domain;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class LeaderBoardRow {

    private String userId;
    private Long totalScore;

    public LeaderBoardRow() {
        this.userId = StringUtils.EMPTY;
        this.totalScore = 0L;
    }

    public LeaderBoardRow(String userId, long totalScore) {
        this.userId = userId;
        this.totalScore = totalScore;
    }
}
