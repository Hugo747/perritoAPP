package com.proyectoe.perritoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.proyectoe.perritoapp.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter1 extends RecyclerView.Adapter {

    private LayoutInflater mLayoutInflater;
    private List<Animal> animalList = new ArrayList<>(); //dataSet
    private Context mContext;
    private OnItemClickListener listener;

    //Constructor
    public AnimalAdapter1(List<Animal> animalList, Context mContext,
                          OnItemClickListener listener) {
        this.animalList = animalList;
        this.mContext = mContext;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //  View view = mLayoutInflater.inflate(R.layout.item_list_animal, parent, false);

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_animal, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animal animal = animalList.get(position);
        holder.textView.setText(animal.getName());
        Glide.with(holder.imageView.getContext())
                .load(animal.getUrl())
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return animalList.size();
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
            listener.onClick(this, getNameByPosition(getAdapterPosition())
                    , getURLByPosition(getAdapterPosition()));
        }
    }

    private String getNameByPosition(int position){
        if (position != RecyclerView.NO_POSITION){
            return animalList.get(position).getName();
        } else {
            return "No Hay";
        }
    }

    private String getURLByPosition(int position){
        if (position != RecyclerView.NO_POSITION){
            return animalList.get(position).getUrl();
        } else {
            return "No Hay";
        }
    }




    public interface OnItemClickListener{
        public void onClick(AnimalAdapter1.ViewHolder viewHolder, String nameAnimal, String url);
    }


}
