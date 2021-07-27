package com.mathtrainer.backed.gamification.api.controller;

import com.mathtrainer.backed.gamification.domain.GameStatus;
import com.mathtrainer.backed.gamification.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class UserStatusController {

    private final GameService gameService;

    @Autowired
    public UserStatusController(final GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public GameStatus getStatsForUser(@RequestParam("userId") final String userId) {
        return gameService.retrieveStatusForUser(userId);
    }
}
