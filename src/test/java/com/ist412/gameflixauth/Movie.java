package com.ist412.gameflixauth;

public class Movie {
    private Long id;
    private String title;

    public Movie() { }

    public Movie(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
}
