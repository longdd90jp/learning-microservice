package com.mathtrainer.backed.calculator.api.controller;

import com.mathtrainer.backed.calculator.domain.MultiplicationResultAttempt;
import com.mathtrainer.backed.calculator.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class provides a REST API to POST the attempts from users.
 */
@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;

    @Autowired
    MultiplicationResultAttemptController(final MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @PostMapping
    ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
        boolean isCorrect = multiplicationService.checkAttempt(multiplicationResultAttempt);
        MultiplicationResultAttempt attemptCopy = new MultiplicationResultAttempt();
        attemptCopy.setUserId(multiplicationResultAttempt.getUserId());
        attemptCopy.setResultAttempt(multiplicationResultAttempt.getResultAttempt());
        attemptCopy.setMultiplication(multiplicationResultAttempt.getMultiplication());
        attemptCopy.setCorrect(isCorrect);
        return ResponseEntity.ok(attemptCopy);
    }

    @GetMapping
    ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(@RequestParam("userid") String userId) {
        return ResponseEntity.ok(
                multiplicationService.getStatsForUser(userId, 5)
        );
    }

    @GetMapping("/{resultId}")
    ResponseEntity<MultiplicationResultAttempt> getResultById(final @PathVariable("resultId") String resultId) {
        return ResponseEntity.ok(
                multiplicationService.getResultById(resultId)
        );
    }
}
