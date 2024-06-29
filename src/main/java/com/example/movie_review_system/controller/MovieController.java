package com.example.movie_review_system.controller;

import com.example.movie_review_system.dto.CreateMovieRequest;
import com.example.movie_review_system.exception.MovieNotFound;
import com.example.movie_review_system.model.Movie;
import com.example.movie_review_system.service.MovieService;
import com.example.movie_review_system.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final MovieService movieService;

    //localhost:9000/movie
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        log.info("received request to fetch all movies");
        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable final int id) throws MovieNotFound {
        log.info("received request to fetch a movie with {}", id);
        final Optional<Movie> movieOptional = movieService.getMovie(id);
        return movieOptional.map(ResponseEntity::ok)
                .orElseThrow(() -> new MovieNotFound(String.format("Could not find a movie with id %s", id)));
    }


    @PostMapping
    public ResponseEntity<Object> createMovie(@RequestBody final CreateMovieRequest createMovieRequest) {
        log.info("received request to create a movie with {}", createMovieRequest);
        return ResponseEntity.ok(movieService.createMovie(createMovieRequest));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteMovie(@PathVariable final int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok(String.format("Successfully deleted movie with id %d", id));
    }

}
