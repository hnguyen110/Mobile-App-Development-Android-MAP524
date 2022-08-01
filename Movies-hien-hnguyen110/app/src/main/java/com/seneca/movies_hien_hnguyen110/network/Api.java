package com.seneca.movies_hien_hnguyen110.network;

import com.seneca.movies_hien_hnguyen110.models.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    public final String BASE_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=b4d88dec34dfb58b79d924faf1cf14c3&language=en-US&page=1&region=CA/";

    @GET()
    public Call<MovieResponse> getMovies();
}
