package com.seneca.movies_hien_hnguyen110;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.seneca.movies_hien_hnguyen110.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}