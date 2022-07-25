package com.seneca.a3_hien_hnguyen110;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.seneca.a3_hien_hnguyen110.databinding.ActivityMainBinding;
import com.seneca.a3_hien_hnguyen110.models.Data;
import com.seneca.a3_hien_hnguyen110.models.Equipment;
import com.seneca.a3_hien_hnguyen110.network.Api;
import com.seneca.a3_hien_hnguyen110.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        api = ApiClient.getInstance().getApi();
        Call<Data> request = api.getEquipments();
        request.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                Log.d("API Request", "Successfully request the equipment data");
                if (!response.isSuccessful()) {
                    Log.d("API Response", response.message());
                }
                Data data = response.body();
                if (data != null) {

                }
            }

            @Override
            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                Log.d("API Request", "Failed to request the equipment data");
                Log.d("API Request Error Message", t.getMessage());
            }
        });
    }
}