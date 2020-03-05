package com.proyectoe.perritoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.proyectoe.perritoapp.api.ApiDog;
import com.proyectoe.perritoapp.api.RetrofitClient;
import com.proyectoe.perritoapp.model.BreedImageListResponse;
import com.proyectoe.perritoapp.model.BreedListResponse;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String perro1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiDog api = RetrofitClient.getRetrofit().create(ApiDog.class);


        Call<BreedListResponse> call=api.getBreedList();

        call.enqueue(new Callback<BreedListResponse>() {
            @Override
            public void onResponse(Call<BreedListResponse> call, Response<BreedListResponse> response) {

                List<String> perritos = null;

                if (response.body() != null) {
                    perritos = response.body().getBreedList();
                    Log.e("PERRITOS","entro aqui");

                }else{

                    Log.e("PERRITOS1","entro aqui 2");

                }
                Log.e("PERRITOS", String.valueOf(perritos));
                Log.e("PERRITOS1","entro aqui 3");
                perro1 = perritos.get(1);
                Log.e("PERRITOS","entro aqui 4");


                if (!perro1.equals("")) {
                    whoLetTheDogsOut();
                }

            }

            @Override
            public void onFailure(Call<BreedListResponse> call, Throwable t) {

            }
        });


    }


    private void whoLetTheDogsOut() {
        ApiDog service = RetrofitClient.getRetrofit().create(ApiDog.class);
        Call<BreedImageListResponse> callImages = service.getBreedImageList(perro1);
        callImages.enqueue(new Callback<BreedImageListResponse>() {
            @Override
            public void onResponse(Call<BreedImageListResponse> call, Response<BreedImageListResponse> response) {
                List<String> imagesURL = response.body().getImageURL();
                Log.e("IMAGESDOGS", String.valueOf(imagesURL));
            }
            @Override
            public void onFailure(Call<BreedImageListResponse> call, Throwable t) {
                Log.e("FALLO", String.valueOf(t));
            }
        });
    }
}



