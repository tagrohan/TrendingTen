package com.example.trendingten.controllers;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendingten.databinding.RecyclerViewBinding;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHol> {

    public MyCallBack callBack;


    @NonNull
    @Override
    public ViewHol onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHol(RecyclerViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHol holder, int position) {
        holder.binding.thumbnail.setOnClickListener(view -> {
            callBack.callBack(position);
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHol extends RecyclerView.ViewHolder {
        RecyclerViewBinding binding;

        public ViewHol(RecyclerViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface MyCallBack {
        void callBack(int position);
    }
}
