package com.seneca.a3_hien_hnguyen110;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.seneca.a3_hien_hnguyen110.adapters.EquipmentAdapter;
import com.seneca.a3_hien_hnguyen110.databinding.ActivityMainBinding;
import com.seneca.a3_hien_hnguyen110.models.Data;
import com.seneca.a3_hien_hnguyen110.models.Equipment;
import com.seneca.a3_hien_hnguyen110.network.Api;
import com.seneca.a3_hien_hnguyen110.network.ApiClient;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final ArrayList<Equipment> equipments = new ArrayList<>();
    private final ArrayList<String> locations = new ArrayList<>();
    EquipmentAdapter equipmentAdapter;
    private ActivityMainBinding binding;
    private Data data;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Api api = ApiClient.getInstance().getApi();
        Call<Data> request = api.getEquipments();
        request.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                Log.d("API Request", "Successfully request the equipment data");
                if (!response.isSuccessful()) {
                    Log.d("API Response", response.message());
                }
                data = response.body();
                if (data != null) {
                    locations.add("Choose a location");
                    locations.addAll(Arrays.asList(data.getAllLocations()));
                    ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(
                            getApplicationContext(),
                            R.layout.spinner_row,
                            locations
                    );
                    binding.locations.setAdapter(locationAdapter);
                    equipments.addAll(data.getData());
                    equipmentAdapter = new EquipmentAdapter(getApplicationContext(), equipments);
                    binding.results.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    binding.results.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
                    binding.results.setAdapter(equipmentAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                Log.d("API Request", "Failed to request the equipment data");
                Log.d("API Request Error Message", t.getMessage());
            }
        });

        binding.locations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                equipments.clear();
                equipments.addAll(data.getDataByLocation(locations.get(i)));
                equipmentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        binding.searchButton.setOnClickListener(view -> {
            String query = binding.itemName.getText().toString();
            equipments.clear();
            if (!query.equals("")) {
                equipments.addAll(data.getDataByName(query));
                binding.itemName.setText("");
            }
            equipmentAdapter.notifyDataSetChanged();
        });
    }
}