package com.seneca.t1_hien_hnguyen110;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.seneca.t1_hien_hnguyen110.adapters.PokemonRowAdapter;
import com.seneca.t1_hien_hnguyen110.database.SingletonPokemonDatabase;
import com.seneca.t1_hien_hnguyen110.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SharedPreferences favouriteSharedPreferences;
    private SingletonPokemonDatabase database;
    private PokemonRowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        favouriteSharedPreferences = getSharedPreferences("favouriteSharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = favouriteSharedPreferences.edit();
        editor.putBoolean("25", true);
        editor.apply();
        database = SingletonPokemonDatabase.getInstance();
        adapter = new PokemonRowAdapter(this, favouriteSharedPreferences, database.getPokemonList());
        binding.pokemonList.setAdapter(adapter);
        binding.pokemonList.setOnItemClickListener((adapterView, view, i, l) -> {

        });
    }
}