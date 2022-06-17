package com.seneca.t1_hien_hnguyen110.database;

import com.seneca.t1_hien_hnguyen110.models.Pokemon;

import java.util.ArrayList;

public class SingletonPokemonDatabase {
    private static SingletonPokemonDatabase instance = null;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

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
        for (Pokemon record : pokemons) {
            if (record.getPokeIndex() == pokedexNumber) {
                pokemon = record;
                break;
            }
        }
        return pokemon;
    }

    private void loadPokemonDataSet() {
        this.pokemons.add(new Pokemon(12, "Caterpie"));
        this.pokemons.add(new Pokemon(19, "Rattata"));
        this.pokemons.add(new Pokemon(25, "Pikachu"));
        this.pokemons.add(new Pokemon(147, "Dratini"));
    }
}
