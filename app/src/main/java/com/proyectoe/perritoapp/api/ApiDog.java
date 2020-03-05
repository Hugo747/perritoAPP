package com.proyectoe.perritoapp.api;

import com.proyectoe.perritoapp.model.BreedImageListResponse;
import com.proyectoe.perritoapp.model.BreedListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiDog {

    @GET("api/breeds/list/")
    Call<BreedListResponse> getBreedList();

    @GET("api/breeds/{}/images/")
    Call<BreedImageListResponse> getBreedImageList(@Path("breed") String breed);//////////concatenando la url





}
