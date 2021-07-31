package com.example.trendingten.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.trendingten.R;
import com.example.trendingten.databinding.TinderViewBinding;
import com.example.trendingten.models.Card;

import java.util.List;

public class CardRecycler extends RecyclerView.Adapter<CardRecycler.ViewHol> {

    private Context context;
    private List<Card> data;
    private static final String URL = "http://192.168.43.64:8080/image/";

    public CardRecycler(Context context, List<Card> data) {
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

        Card content = data.get(position);
        holder.binding.name.setText(content.getName());
        holder.binding.content.setText(content.getContent());
        holder.binding.number.setText(content.getNumber());
        try {
            Glide.with(context)
                    .load(URL + content.getUri())
                    .placeholder(R.drawable.placeholder)
                    .into(holder.binding.image);
        } catch (Exception e) {
            holder.binding.image.setImageResource(R.drawable.ola);
        }

    }


    public void updatingRecycler(List<Card> cards) {
        this.data.clear();
        this.data.addAll(cards);
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
