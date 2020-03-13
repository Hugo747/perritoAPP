package com.proyectoe.perritoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyectoe.perritoapp.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter  extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {


    private LayoutInflater mLayoutInflater;
    private List<Animal> animalList = new ArrayList<>(); //dataSet
    private Context mContext;
    private AnimalAdapter1.OnItemClickListener listener;

    public AnimalAdapter(List<Animal> animalList, Context mContext, AnimalAdapter1.OnItemClickListener listener) {
        this.animalList = animalList;
        this.mContext = mContext;
        this.listener = listener;
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewListItem);
            textView = itemView.findViewById(R.id.textVIewListItem);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {


        }
    }

    public interface OnItemClickListener{
        public void onClick(AnimalAdapter.ViewHolder viewHolder, String nameAnimal, String url);
    }
}
