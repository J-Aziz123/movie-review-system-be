package com.example.movie_review_system.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateMovieRequest {

    private String title;
    private String trailerLink;
    private String posterLink;

}
