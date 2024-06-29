package com.example.movie_review_system.service;

import com.example.movie_review_system.dto.CreateReviewRequest;
import com.example.movie_review_system.exception.MovieNotFound;
import com.example.movie_review_system.model.Movie;
import com.example.movie_review_system.model.Review;
import com.example.movie_review_system.repository.MovieRepository;
import com.example.movie_review_system.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

   private final ReviewRepository reviewRepository;
   private final MovieRepository movieRepository;

   public Review createReview(final int movieId, final CreateReviewRequest createReviewRequest) throws MovieNotFound {
       final Optional<Movie> movieOptional = movieRepository.findById(movieId);
       final Review review = movieOptional.map(movie -> Review.builder()
               .userName(createReviewRequest.getUserName())
               .reviewBody(createReviewRequest.getReviewBody())
               .createdAt(Instant.now())
               .updateAt(Instant.now())
               .movie(movieOptional.get())
               .build())
               .orElseThrow(()-> new MovieNotFound(String.format("Movie with id %d not found", movieId)));
       return reviewRepository.save(review);

   }

    public void deleteReview(final int reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
