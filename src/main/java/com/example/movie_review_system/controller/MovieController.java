package com.example.movie_review_system.controller;

import com.example.movie_review_system.dto.CreateMovieRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieController {

    //localhost:9000/movie
    @GetMapping
    public ResponseEntity<Object> getMovies() {
        log.info("received request to fetch all movies");
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMovie(@PathVariable final int id) {
        log.info("received request to fetch a movie with {}", id);
        return ResponseEntity.ok("");
    }


    @PostMapping
    public ResponseEntity<Object> getMovie(@RequestBody final CreateMovieRequest createMovieRequest) {
        log.info("received request to create a movie with {}", createMovieRequest);
        return ResponseEntity.ok("");
    }

}
