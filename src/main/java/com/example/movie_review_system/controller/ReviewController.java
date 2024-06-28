package com.example.movie_review_system.controller;


import com.example.movie_review_system.dto.CreateReviewRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@Slf4j
public class ReviewController {

    @PostMapping("/{id}")
    ResponseEntity<Object> createReview(@PathVariable final int id,
            @RequestBody final CreateReviewRequest createReviewRequest) {
        log.info("received request to create a review {} for movie id : {}", createReviewRequest, id);
        return ResponseEntity.ok("Hello");
    }

}
