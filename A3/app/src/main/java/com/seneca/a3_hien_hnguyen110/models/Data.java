package com.seneca.a3_hien_hnguyen110.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Data {
    private ArrayList<Equipment> data;
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

    public ArrayList<Equipment> getDataByLocation(String location) {
        ArrayList<Equipment> equipments = new ArrayList<>();
        for (Equipment equipment : data) {
            if (equipment.getCommonLocations() != null) {
                if (Arrays.asList(equipment.getCommonLocations()).contains(location)) {
                    equipments.add(equipment);
                }
            }
        }
        return equipments;
    }

    public ArrayList<Equipment> getDataByName(String name) {
        ArrayList<Equipment> equipments = new ArrayList<>();
        for (Equipment equipment : data) {
            if (equipment.getName() != null) {
                String equipmentName = equipment.getName();
                if (equipmentName.toLowerCase().contains(name.toLowerCase())) {
                    equipments.add(equipment);
                }
            }
        }
        return equipments;
    }

    public ArrayList<Equipment> getData() {
        return data;
    }
}
