package com.example.trendingten.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.trendingten.R;
import com.example.trendingten.databinding.TinderViewBinding;
import com.example.trendingten.models.Card;

import java.util.List;

public class ShortRecycler extends RecyclerView.Adapter<ShortRecycler.ViewHol> {

    private List<Card> cards;
    private static final String URL = "http://192.168.0.3:8080/image/";

    public ShortRecycler(List<Card> cards) {
        this.cards = cards;
    }


    @NonNull
    @Override
    public ShortRecycler.ViewHol onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHol(TinderViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShortRecycler.ViewHol holder, int position) {
        if (cards != null && cards.size() > 0) {
            Card t = cards.get(position);
            holder.binding.name.setText(t.getName());
            Glide.with(holder.itemView.getContext())
                    .load(URL + t.getUri())
                    .placeholder(R.drawable.placeholder)
                    .into(holder.binding.image);
            holder.binding.content.setText(t.getContent());
            holder.binding.number.setVisibility(View.INVISIBLE);
        }
    }

    public void updatingRecycler(List<Card> cards) {
        this.cards.clear();
        this.cards.addAll(cards);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class ViewHol extends RecyclerView.ViewHolder {
        TinderViewBinding binding;

        public ViewHol(@NonNull TinderViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

