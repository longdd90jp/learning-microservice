package com.mathtrainer.backed.gamification.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Calendar;
import java.util.Date;

@Data
@Document("badge_cards")
@ToString
@EqualsAndHashCode
public class BadgeCard {

    @Id
    private String id;

    private String userId;

    private Date badgeTimestamp;
    private Badge badge;

    // Empty constructor for JSON / JPA
    public BadgeCard() {
        this.badgeTimestamp = Calendar.getInstance().getTime();
    }

    public BadgeCard(final String userId, final Badge badge) {
        this.userId = userId;
        this.badge = badge;
        this.badgeTimestamp = Calendar.getInstance().getTime();
    }
}
