package com.example.trendingten.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendingten.R;
import com.example.trendingten.databinding.TinderViewBinding;
import com.example.trendingten.models.CardData;

import java.util.List;

public class CardRecycler extends RecyclerView.Adapter<CardRecycler.ViewHol> {

    private Context context;
    List<CardData> data;

    public CardRecycler(Context context, List<CardData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHol onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHol(TinderViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHol holder, int position) {

        try {
            CardData content = data.get(position);


            holder.binding.image.setImageResource(content.getImage());
            holder.binding.name.setText(content.getName());
            holder.binding.content.setText(content.getContent());
            holder.binding.number.setText(content.getNumber());

        } catch (Exception e) {
            holder.binding.image.setImageResource(R.drawable.ola);
        }

//        callBack.tinderCallBack(position, holder.binding);
        holder.binding.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "clicked " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updatingRecycler(List<CardData> cardData) {
        this.data.clear();
        this.data.addAll(cardData);
        notifyDataSetChanged();

    }


    @Override
    public int getItemCount() {
        return data.size() != 0 ? data.size() : 10;
    }

    public class ViewHol extends RecyclerView.ViewHolder {
        TinderViewBinding binding;

        public ViewHol(@NonNull TinderViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
