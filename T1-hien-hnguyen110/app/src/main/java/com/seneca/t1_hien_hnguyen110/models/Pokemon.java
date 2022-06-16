package com.seneca.t1_hien_hnguyen110.models;

public class Pokemon {
    private int pokedex;
    private String name;
    private int wins = 0;
    private int losses = 0;

    public Pokemon(int pokedex, String name) {
        this.pokedex = pokedex;
        this.name = name;
    }

    public int getPokedex() {
        return pokedex;
    }

    public void setPokedex(int pokedex) {
        this.pokedex = pokedex;
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
