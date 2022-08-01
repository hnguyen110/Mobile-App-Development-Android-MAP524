package com.seneca.movies_hien_hnguyen110.models;

import androidx.annotation.NonNull;

import java.util.Arrays;

public class MovieResponse {
    private Movie[] results;

    public Movie[] getResults() {
        return results;
    }

    public void setResults(Movie[] results) {
        this.results = results;
    }

    @NonNull
    @Override
    public String toString() {
        return "MovieResponse{" +
                "results=" + Arrays.toString(results) +
                '}';
    }
}
