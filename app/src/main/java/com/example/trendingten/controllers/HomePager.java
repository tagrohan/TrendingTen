package com.example.trendingten.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendingten.databinding.RecyclerViewBinding;


public class HomePager extends RecyclerView.Adapter<HomePager.ViewHol> {
    public ItemPosition itemPosition;

    public HomePager() {
        // will add stuff later
    }


    @NonNull
    @Override
    public ViewHol onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHol(RecyclerViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHol holder, int position) {

        holder.innerBin.connect.setOnClickListener(view -> {
            holder.innerBin.connect.setText("connection");

        });

        holder.innerBin.bookmark.setOnClickListener(view -> {
            holder.innerBin.bookmark.playAnimation();
        });

        holder.innerBin.likeButton.setOnClickListener(view -> {
            animateImage(holder.innerBin.likeButton);
        });
        holder.innerBin.share.setOnClickListener(view -> {
            animateImage(holder.innerBin.share);
        });

        holder.innerBin.thumbnail.setOnClickListener(view -> {
            itemPosition.itemPosition(position);
        });
        holder.innerBin.connect.setOnClickListener(view -> {
            animateImage(holder.innerBin.connect);
            holder.innerBin.connect.setText("connected");
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }


    class ViewHol extends RecyclerView.ViewHolder {
        RecyclerViewBinding innerBin;

        public ViewHol(RecyclerViewBinding innerBin) {
            super(innerBin.getRoot());
            this.innerBin = innerBin;
        }
    }

    private void animateImage(final View view) {
        view.animate().scaleX(0.7f).scaleY(0.7f).setDuration(80).withEndAction(new Runnable() {
            @Override
            public void run() {
                view.animate().scaleX(1f).scaleY(1f);
            }
        });
    }

    public interface ItemPosition {
        void itemPosition(int position);
    }


}
