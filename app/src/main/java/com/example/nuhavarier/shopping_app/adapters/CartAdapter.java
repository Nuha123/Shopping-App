package com.example.nuhavarier.shopping_app.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nuhavarier.shopping_app.R;

public class CartAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cartItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_clothing, parent, false);
        return new RecyclerView.ViewHolder(cartItem){
            };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
