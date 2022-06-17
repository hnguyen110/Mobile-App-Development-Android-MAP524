package com.seneca.t1_hien_hnguyen110.database;

import android.content.SharedPreferences;

import com.seneca.t1_hien_hnguyen110.models.Pokemon;

import java.util.ArrayList;

public class SingletonPokemonDatabase {
    private static SingletonPokemonDatabase instance = null;
    private ArrayList<Pokemon> pokemonList = new ArrayList<>();

    private SingletonPokemonDatabase() {
        loadPokemonDataSet();
    }

    public static SingletonPokemonDatabase getInstance() {
        if (instance == null) {
            instance = new SingletonPokemonDatabase();
        }
        return instance;
    }

    public Pokemon getPokemonById(int pokedexNumber) {
        Pokemon pokemon = null;
        for (Pokemon record : pokemonList) {
            if (record.getPokeIndex() == pokedexNumber) {
                pokemon = record;
                break;
            }
        }
        return pokemon;
    }

    private void loadPokemonDataSet() {
        this.pokemonList.add(new Pokemon(12, "Caterpie"));
        this.pokemonList.add(new Pokemon(19, "Rattata"));
        this.pokemonList.add(new Pokemon(25, "Pikachu"));
        this.pokemonList.add(new Pokemon(147, "Dratini"));
    }

    public static void setInstance(SingletonPokemonDatabase instance) {
        SingletonPokemonDatabase.instance = instance;
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
