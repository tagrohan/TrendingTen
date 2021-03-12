package com.example.trendingten.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendingten.R;

public class TestingRecycler extends RecyclerView.Adapter<TestingRecycler.ViewHol> {

    @NonNull
    @Override
    public ViewHol onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHol(LayoutInflater.from(parent.getContext()).inflate(R.layout.testing_layout, parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHol holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class ViewHol extends RecyclerView.ViewHolder {

        public ViewHol(@NonNull View itemView) {
            super(itemView);
        }
    }
}
