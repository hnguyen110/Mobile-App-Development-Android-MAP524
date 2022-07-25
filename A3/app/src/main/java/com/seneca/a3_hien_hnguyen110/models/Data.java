package com.seneca.a3_hien_hnguyen110.models;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.HashSet;

public class Data {
    private Equipment[] data;
    private String[] locations;

    public String[] getAllLocations() {
        if (locations == null) {
            HashSet<String> set = new HashSet<>();
            for (Equipment equipment : data) {
                if (equipment.getCommonLocations() != null) {
                    set.addAll(Arrays.asList(equipment.getCommonLocations()));
                }
            }
            locations = new String[set.size()];
            set.toArray(locations);
        }
        return locations;
    }

    public Equipment[] getData() {
        return data;
    }

    @NonNull
    @Override
    public String toString() {
        return "Data{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
