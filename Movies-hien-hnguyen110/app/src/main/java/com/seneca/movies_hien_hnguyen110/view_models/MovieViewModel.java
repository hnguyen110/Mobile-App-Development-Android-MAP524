package com.seneca.movies_hien_hnguyen110.view_models;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.seneca.movies_hien_hnguyen110.models.Movie;
import com.seneca.movies_hien_hnguyen110.models.MovieResponse;
import com.seneca.movies_hien_hnguyen110.network.Api;
import com.seneca.movies_hien_hnguyen110.network.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Movie>> results;
    public LiveData<ArrayList<Movie>> getMovies() {
        if (results == null) {
            results = new MutableLiveData<>();
            Api api = ApiClient.getInstance().getApi();
            Call<MovieResponse> request = api.getMovies("b4d88dec34dfb58b79d924faf1cf14c3", "en-US", "1", "CA");
            request.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                    if (!response.isSuccessful()) {
                        Log.d("Movie API Response", response.message());
                    }
                    MovieResponse data = response.body();
                    if (data != null) {
                        results.setValue(data.getResults());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<MovieResponse> call, @NonNull Throwable t) {
                    Log.d("Movie API Request", "Failed to request the equipment data");
                    Log.d("Movie API Request", t.getMessage());
                }
            });
        }
        return results;
    }
}
