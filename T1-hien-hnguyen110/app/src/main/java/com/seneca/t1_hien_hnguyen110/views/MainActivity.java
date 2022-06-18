package com.seneca.t1_hien_hnguyen110.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.seneca.t1_hien_hnguyen110.adapters.PokemonRowAdapter;
import com.seneca.t1_hien_hnguyen110.database.SingletonPokemonDatabase;
import com.seneca.t1_hien_hnguyen110.databinding.ActivityMainBinding;
import com.seneca.t1_hien_hnguyen110.models.Pokemon;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null;
    private SharedPreferences favouriteSharedPreferences = null;
    private SingletonPokemonDatabase database = null;
    private PokemonRowAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        favouriteSharedPreferences = getSharedPreferences("favouriteSharedPreferences", Context.MODE_PRIVATE);
        database = SingletonPokemonDatabase.getInstance();
        adapter = new PokemonRowAdapter(this, favouriteSharedPreferences, database.getPokemonList());
        binding.pokemonList.setAdapter(adapter);
        binding.pokemonList.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(getApplicationContext(), PokemonDetailsActivity.class);
            Pokemon pokemon = database.getPokemonList().get(i);
            System.out.println(pokemon.getPokeIndex());
            intent.putExtra("EXTRA_POKEMON_INDEX", pokemon.getPokeIndex());
            startActivity(intent);
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }
}