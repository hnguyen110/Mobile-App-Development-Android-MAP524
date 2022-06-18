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

import com.google.android.material.snackbar.Snackbar;
import com.seneca.t1_hien_hnguyen110.R;
import com.seneca.t1_hien_hnguyen110.database.SingletonPokemonDatabase;
import com.seneca.t1_hien_hnguyen110.databinding.ActivityPokemonDetailsBinding;
import com.seneca.t1_hien_hnguyen110.models.Pokemon;

import java.util.Random;

public class PokemonDetailsActivity extends AppCompatActivity {
    private ActivityPokemonDetailsBinding binding;
    private SharedPreferences favouriteSharedPreferences;
    private SingletonPokemonDatabase database;
    private Pokemon pokemon = null;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPokemonDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            favouriteSharedPreferences = getSharedPreferences("favouriteSharedPreferences", Context.MODE_PRIVATE);
            database = SingletonPokemonDatabase.getInstance();
            int index = intent.getIntExtra("EXTRA_POKEMON_INDEX", -1);
            pokemon = database.getPokemonById(index);
            binding.name.setText(String.format("Name: %s", pokemon.getName()));
            binding.pokeIndex.setText(String.format("Pokedex Number: %d", pokemon.getPokeIndex()));
            int image = getResources().getIdentifier(pokemon.getName().toLowerCase(), "drawable", getPackageName());
            binding.image.setImageResource(image);
            binding.fightComputerButton.setOnClickListener(view -> {
                fightComputer();
            });
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
                setAsFavourite();
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
        if (pokemon != null) {
            pokemon.setWins(0);
            pokemon.setLosses(0);
            SharedPreferences.Editor editor = favouriteSharedPreferences.edit();
            editor.remove(String.format("KEY_%d", pokemon.getPokeIndex()));
            editor.apply();
        }
    }

    @SuppressLint("DefaultLocale")
    private void setAsFavourite() {
        if (pokemon != null) {
            SharedPreferences.Editor editor = favouriteSharedPreferences.edit();
            editor.putBoolean(String.format("KEY_%d", pokemon.getPokeIndex()), true);
            editor.apply();
        }
    }

    @SuppressLint("DefaultLocale")
    private void fightComputer() {
        int first = new Random().nextInt(5) + 1;
        int second = new Random().nextInt(5) + 1;
        if (first > second) {
            pokemon.setWins(pokemon.getWins() + 1);
        } else {
            pokemon.setLosses(pokemon.getLosses() + 1);
        }
        Snackbar.make(binding.getRoot(), String.format("Player: %d, Computer: %d, Winner: %s", first, second, first > second ? "Player" : "Computer"), Snackbar.LENGTH_SHORT).show();
    }
}