package com.seneca.t1_hien_hnguyen110.models;

public class Pokemon {
    private int pokeIndex;
    private String name;
    private int wins = 0;
    private int losses = 0;

    public Pokemon(int pokeIndex, String name) {
        this.pokeIndex = pokeIndex;
        this.name = name;
    }

    public int getPokeIndex() {
        return pokeIndex;
    }

    public void setPokeIndex(int pokeIndex) {
        this.pokeIndex = pokeIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
