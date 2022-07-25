package com.seneca.a3_hien_hnguyen110.network;

import com.seneca.a3_hien_hnguyen110.models.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    public final String BASE_URL = "https://botw-compendium.herokuapp.com/api/v2/";

    @GET("category/equipment")
    public Call<Data> getEquipments();
}
