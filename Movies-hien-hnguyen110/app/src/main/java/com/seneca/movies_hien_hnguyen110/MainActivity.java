package com.seneca.movies_hien_hnguyen110;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.seneca.movies_hien_hnguyen110.database.Database;
import com.seneca.movies_hien_hnguyen110.databinding.ActivityMainBinding;
import com.seneca.movies_hien_hnguyen110.models.Purchase;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Database database = Database.getDatabase(getApplicationContext());
    }
}