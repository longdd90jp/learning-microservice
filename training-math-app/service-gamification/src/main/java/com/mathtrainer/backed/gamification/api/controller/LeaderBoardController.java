package com.mathtrainer.backed.gamification.api.controller;

import com.mathtrainer.backed.common.constants.CommonConsant;
import com.mathtrainer.backed.gamification.domain.LeaderBoardRow;
import com.mathtrainer.backed.gamification.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This class implements a REST API for the Gamification LeaderBoard service.
 */
@RestController
@RequestMapping("/leaders")
class LeaderBoardController {

    private final LeaderBoardService leaderBoardService;
    private HttpServletRequest request;

    private static final int TOP_RANGE_VAL = 10;

    @Autowired
    public LeaderBoardController(final LeaderBoardService leaderBoardService, HttpServletRequest request) {
        this.leaderBoardService = leaderBoardService;
        this.request = request;
    }

    @GetMapping
    public List<LeaderBoardRow> getLeaderBoard() {
        return leaderBoardService.getCurrentLeaderBoard(TOP_RANGE_VAL);
    }
}
