package com.example.movie_review_system.service;

import com.example.movie_review_system.dto.CreateMovieRequest;
import com.example.movie_review_system.model.Movie;
import com.example.movie_review_system.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;


    public List<Movie> getMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    public Optional<Movie> getMovie(final int id) {
        return  movieRepository.findById(id);
    }

    public Movie createMovie(final CreateMovieRequest createMovieRequest) {
        final Movie movie = Movie.builder()
                .title(createMovieRequest.getTitle())
                .poster(createMovieRequest.getPosterLink())
                .trailerLink(createMovieRequest.getTrailerLink())
                .build();
        return movieRepository.save(movie);
    }


    public void deleteMovie(final int movieId) {
        movieRepository.deleteById(movieId);
    }


}
