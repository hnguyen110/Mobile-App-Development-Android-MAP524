package com.seneca.movies_hien_hnguyen110.models;

import java.util.ArrayList;

public class MovieResponse {
    private ArrayList<Movie> results = new ArrayList<>();

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }
}
