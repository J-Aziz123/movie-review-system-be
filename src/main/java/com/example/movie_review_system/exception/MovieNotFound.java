package com.example.movie_review_system.exception;

public class MovieNotFound extends Exception {

    public MovieNotFound(final String errorMessage) {
        super(errorMessage);
    }

    public MovieNotFound(final String errorMessage, final Throwable throwable) {
        super(errorMessage, throwable);
    }
}

