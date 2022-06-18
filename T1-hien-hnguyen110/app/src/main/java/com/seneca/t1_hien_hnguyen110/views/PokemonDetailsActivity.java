package com.seneca.t1_hien_hnguyen110.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.seneca.t1_hien_hnguyen110.R;
import com.seneca.t1_hien_hnguyen110.database.SingletonPokemonDatabase;
import com.seneca.t1_hien_hnguyen110.databinding.ActivityPokemonDetailsBinding;
import com.seneca.t1_hien_hnguyen110.models.Pokemon;

public class PokemonDetailsActivity extends AppCompatActivity {
    private ActivityPokemonDetailsBinding binding;
    private SharedPreferences favouriteSharedPreferences;
    private SingletonPokemonDatabase database;
    private int pokeIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPokemonDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            favouriteSharedPreferences = getSharedPreferences("favouriteSharedPreferences", Context.MODE_PRIVATE);
            database = SingletonPokemonDatabase.getInstance();
            pokeIndex = intent.getIntExtra("EXTRA_POKEMON_INDEX", -1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pokemon_details_options_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setAsFavouriteOption:
                return true;
            case R.id.resetOption:
                reset();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressLint("DefaultLocale")
    private void reset() {
        Pokemon pokemon = database.getPokemonById(pokeIndex);
        if (pokemon != null) {
            pokemon.setWins(0);
            pokemon.setLosses(0);
            SharedPreferences.Editor editor = favouriteSharedPreferences.edit();
            editor.remove(String.format("KEY_%d", pokemon.getPokeIndex()));
            editor.apply();
        }
    }
}