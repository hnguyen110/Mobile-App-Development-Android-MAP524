package com.seneca.t1_hien_hnguyen110.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.seneca.t1_hien_hnguyen110.R;
import com.seneca.t1_hien_hnguyen110.databinding.PokemonRowLayoutBinding;
import com.seneca.t1_hien_hnguyen110.models.Pokemon;

import java.util.List;

public class PokemonRowAdapter extends ArrayAdapter {
    private SharedPreferences sharedPreferences;
    private final List<Pokemon> pokemonList;

    public PokemonRowAdapter(@NonNull Context context, SharedPreferences sharedPreferences, List<Pokemon> pokemonList) {
        super(context, 0);
        this.sharedPreferences = sharedPreferences;
        this.pokemonList = pokemonList;
    }

    @Override
    public int getCount() {
        return this.pokemonList.size();
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Pokemon pokemon = pokemonList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.pokemon_row_layout, parent, false);
            boolean isFavourite = sharedPreferences.getBoolean(String.format("%d", pokemon.getPokeIndex()), false);
            if (isFavourite) {
                convertView.setBackgroundColor(Color.YELLOW);
            }
        }
        PokemonRowLayoutBinding binding = PokemonRowLayoutBinding.bind(convertView);
        binding.name.setText(pokemon.getName());
        binding.winLossRecord.setText(String.format("Wins: %d - %d", pokemon.getWins(), pokemon.getLosses()));
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
