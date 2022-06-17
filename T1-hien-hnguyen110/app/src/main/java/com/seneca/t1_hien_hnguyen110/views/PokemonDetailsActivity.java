package com.seneca.t1_hien_hnguyen110.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.seneca.t1_hien_hnguyen110.databinding.ActivityPokemonDetailsBinding;

public class PokemonDetailsActivity extends AppCompatActivity {
    private ActivityPokemonDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPokemonDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}