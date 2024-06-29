package com.example.movie_review_system.controller;


import com.example.movie_review_system.dto.CreateReviewRequest;
import com.example.movie_review_system.exception.MovieNotFound;
import com.example.movie_review_system.model.Review;
import com.example.movie_review_system.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{id}")
    ResponseEntity<Review> createReview(@PathVariable final int id,
                                        @RequestBody final CreateReviewRequest createReviewRequest)
            throws MovieNotFound {
        log.info("received request to create a review {} for movie id : {}", createReviewRequest, id);
        return ResponseEntity.ok(reviewService.createReview(id, createReviewRequest));
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteReview(@PathVariable final int id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok(String.format("Successfully deleted review with id %d", id));
    }

}
