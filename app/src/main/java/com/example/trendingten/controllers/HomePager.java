package com.example.trendingten.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.trendingten.R;
import com.example.trendingten.databinding.HomeScreenViewBinding;
import com.example.trendingten.models.Thumbnail;

import java.util.List;


public class HomePager extends RecyclerView.Adapter<HomePager.ViewHol> {
    public ItemPosition itemPosition;
    private List<Thumbnail> thumbnails;
    private static final String URL = "http://localhost:8080/image/";

    public HomePager(List<Thumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }

    @NonNull
    @Override
    public ViewHol onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHol(HomeScreenViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHol holder, int position) {
        if (thumbnails != null && thumbnails.size() > 0) {
            Thumbnail t = thumbnails.get(position);
            Glide.with(holder.itemView.getContext())
                    .load(URL + t.getThumbnailUri())
                    .placeholder(R.drawable.placeholder)
                    .into(holder.innerBin.homeThumbnail);
            holder.innerBin.homeTitle.setText(t.getTitle());
            holder.innerBin.homeThumbnail.setOnClickListener(view -> {
                itemPosition.itemPosition(position);
            });
        }
    }

    @Override
    public int getItemCount() {
        return thumbnails.size() > 0 ? thumbnails.size() : 10;
    }

    public void updateHomeRecycler(List<Thumbnail> thumbnails) {
        this.thumbnails.clear();
        this.thumbnails.addAll(thumbnails);
        notifyDataSetChanged();
    }


    class ViewHol extends RecyclerView.ViewHolder {
        HomeScreenViewBinding innerBin;

        public ViewHol(HomeScreenViewBinding innerBin) {
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
