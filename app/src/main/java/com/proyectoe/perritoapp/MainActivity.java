package com.proyectoe.perritoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.proyectoe.perritoapp.api.ApiDog;
import com.proyectoe.perritoapp.api.RetrofitClient;
import com.proyectoe.perritoapp.model.Animal;
import com.proyectoe.perritoapp.model.BreedImageListResponse;
import com.proyectoe.perritoapp.model.BreedListResponse;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AnimalAdapter1.OnItemClickListener {

    private RecyclerView recyclerView;
    private AnimalAdapter1 adapter;

    private String perro1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.recyclerView);
        adapter = new AnimalAdapter1(initializeAnimals(),this,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

















        ApiDog api = RetrofitClient.getRetrofit().create(ApiDog.class);

        Call<BreedListResponse> call=api.getBreedList();

        call.enqueue(new Callback<BreedListResponse>() {
            @Override
            public void onResponse(Call<BreedListResponse> call, Response<BreedListResponse> response) {

                List<String> perritos = null;

                if (response.body() != null) {
                    perritos = response.body().getBreedList();
                    Log.e("PERRITOS", String.valueOf(perritos));

                }else{

                    Log.e("PERRITOS1","entro aqui 2");

                }
                Log.e("PERRITOS", String.valueOf(perritos));
                Log.e("PERRITOS1","entro aqui 3");
              //  perro1 = perritos.get(1);
                Log.e("PERRITOS","entro aqui 4");


              //  if (!perro1.equals("")) {
           //         whoLetTheDogsOut();
          //      }

            }

            @Override
            public void onFailure(Call<BreedListResponse> call, Throwable t) {

            }
        });


    }
    private List<Animal> initializeAnimals() {

        Animal animal1 = new Animal("https://images.unsplash.com/photo-1497752531616-c3afd9760a11?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "Mapache Chileno");
        Animal animal2 = new Animal("https://images.unsplash.com/photo-1539418561314-565804e349c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80", "Flamingo");
        Animal animal3 = new Animal("https://images.unsplash.com/photo-1503066211613-c17ebc9daef0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "tigre tonny");
        List<Animal> animalList = new ArrayList<Animal>();
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);

        return animalList;
    }






    ////////////////////////////////////////////////////////////////////////////////////////
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

    @Override
    public void onClick(AnimalAdapter1.ViewHolder viewHolder, String nameAnimal, String url) {

    }
}



