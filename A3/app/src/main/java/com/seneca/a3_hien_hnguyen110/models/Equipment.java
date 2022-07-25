package com.seneca.a3_hien_hnguyen110.models;

import androidx.annotation.NonNull;

import java.util.Arrays;

public class Equipment {
    private int id;
    private String image;
    private String name;
    private String description;
    private String category;
    private int attack;
    private int defense;
    private String[] common_locations;

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public String[] getCommon_locations() {
        return common_locations;
    }

    @NonNull
    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", common_locations=" + Arrays.toString(common_locations) +
                '}';
    }
}
