package com.seneca.t1_hien_hnguyen110;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.seneca.t1_hien_hnguyen110.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}