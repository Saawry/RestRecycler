package com.example.actorrest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorHolder> {


    private List<Actor> actorList;
    private Context context;

    public ActorAdapter(List<Actor> actorList, Context context) {
        this.actorList = actorList;
        this.context = context;
    }

    @NonNull
    @Override
    public ActorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.actor_details_card, parent, false);
        return new ActorHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ActorHolder holder, int position) {
        final Actor actor = actorList.get(position);
        Toast.makeText(context, actor.getName(), Toast.LENGTH_SHORT).show();
        holder.id.setText(actor.getId());
        holder.name.setText(actor.getName());
        holder.age.setText(actor.getAge());
        Glide.with(context).load(actor.getImage()).into(holder.actorImg);
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }


    class ActorHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;
        TextView age;
        ImageView actorImg;

        public ActorHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.actor_tv_id);
            name = itemView.findViewById(R.id.actor_tv_name);
            age = itemView.findViewById(R.id.actor_tv_age);
            actorImg = itemView.findViewById(R.id.actor_view_image);

        }
    }
}