package com.ist412.gameflixauth;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    public List<Movie> getAllMovies() {
        return List.of(
                new Movie(1L, "Interstellar"),
                new Movie(2L, "Dune")
        );
    }
}