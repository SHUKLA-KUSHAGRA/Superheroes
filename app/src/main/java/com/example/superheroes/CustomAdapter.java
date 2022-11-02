package com.example.superheroes;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private List<Character> characterList;
    public CustomAdapter(Context context, List<Character> characterList){
        this.context=context;
        this.characterList=characterList;
    }
    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_custom, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Character character=characterList.get(position);
        holder.name.setText(character.getName());
        holder.publisher.setText(character.getPublisher());
        Picasso.get().load(character.getImage_url()).resize(350,250).centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView publisher;
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name=itemView.findViewById(R.id.name);
            publisher=itemView.findViewById(R.id.publisher);
            imageView=itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            Character character=characterList.get(position);
            Intent intent=new Intent(context,MainActivity2.class);
            intent.putExtra("Characters",character);
            context.startActivity(intent);
        }
    }
}
