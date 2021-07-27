package com.mathtrainer.backed.gamification.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Calendar;
import java.util.Date;

@Data
@Document("score_cards")
public class ScoreCard {

    // The default score assigned to this card, if not specified.
    public static final int DEFAULT_SCORE = 10;

    @Id
    private String id;

    private String userId;

    private String attemptId;

    private Date scoreTimestamp;

    private int score;

    // Empty constructor for JSON / JPA
    public ScoreCard() {
        this.scoreTimestamp = Calendar.getInstance().getTime();
        this.score = 0;
    }

    public ScoreCard(final String userId, final String attemptId) {
        this.userId = userId;
        this.attemptId = attemptId;
        this.scoreTimestamp = Calendar.getInstance().getTime();
        this.score = DEFAULT_SCORE;
    }

}
