package com.seneca.a3_hien_hnguyen110.models;

import androidx.annotation.NonNull;

import java.util.Arrays;

public class Data {
    private Equipment[] data;

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
