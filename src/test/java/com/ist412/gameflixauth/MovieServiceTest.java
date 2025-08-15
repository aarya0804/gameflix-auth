package com.ist412.gameflixauth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllMovies_ShouldReturnList() {
        var movies = movieService.getAllMovies();
        Assertions.assertFalse(movies.isEmpty());
    }

    @Test
    void getAllMovies_ShouldNotContainNulls() {
        var movies = movieService.getAllMovies();
        Assertions.assertTrue(movies.stream().allMatch(Objects::nonNull));
    }

    @Test
    void getAllMovies_TwoCallsShouldHaveSameSize() {
        var first = movieService.getAllMovies();
        var second = movieService.getAllMovies();
        Assertions.assertEquals(first.size(), second.size());
    }
}