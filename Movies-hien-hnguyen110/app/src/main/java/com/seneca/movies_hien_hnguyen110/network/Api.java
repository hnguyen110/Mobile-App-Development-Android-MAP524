package com.seneca.movies_hien_hnguyen110.network;

import com.seneca.movies_hien_hnguyen110.models.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://api.themoviedb.org/3/movie/";

    @GET("now_playing?")
    public Call<MovieResponse> getMovies(@Query("api_key") String api_key, @Query("language") String language, @Query("page") String page, @Query("region") String region);
}
