package com.example.cattlehealthmanager.animal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cattlehealthmanager.DatabaseHelper;
import com.example.cattlehealthmanager.R;

import org.jetbrains.annotations.NotNull;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.ViewHolder> {
   Animal[] myAnimal;
   AddAnimal context;
   DatabaseHelper db;

    public AnimalsAdapter(Animal[] myAnimal, AddAnimal addAnimal) {
        this.myAnimal = myAnimal;
        this.context = addAnimal;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_my_animals,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        final  Animal animal = myAnimal[position];

    }

    @Override
    public int getItemCount() {
        return myAnimal.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView list_tag;
        TextView list_category;
        TextView list_gender;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            list_tag = itemView.findViewById(R.id.list_tag);
            list_category = itemView.findViewById(R.id.list_category);
            list_gender = itemView.findViewById(R.id.list_gender);
        }

    }
}
