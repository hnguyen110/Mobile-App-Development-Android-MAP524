package com.seneca.t1_hien_hnguyen110.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.seneca.t1_hien_hnguyen110.R;
import com.seneca.t1_hien_hnguyen110.databinding.ActivityPokemonDetailsBinding;

public class PokemonDetailsActivity extends AppCompatActivity {
    private ActivityPokemonDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPokemonDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
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
                return true;
            default:
                return true;
        }
    }
}