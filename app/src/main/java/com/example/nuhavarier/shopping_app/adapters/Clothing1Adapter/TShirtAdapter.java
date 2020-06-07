package com.example.nuhavarier.shopping_app.adapters.Clothing1Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nuhavarier.shopping_app.R;
import com.example.nuhavarier.shopping_app.activities.ItemDetailsActivity;
import com.squareup.picasso.Picasso;

public class TShirtAdapter extends RecyclerView.Adapter<TShirtAdapter.MyViewHolder> {
    Context context;
    public TShirtAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singleItemClothingView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_clothing, parent, false);
        return new MyViewHolder(singleItemClothingView) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        final MyTees tees = teesDataLists.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ItemDetailsActivity.class);
//                intent.putExtra("tees_data",tees);
                context.startActivity(intent);
            }
        });



        Picasso.with(context).load("https://tse1.mm.bing.net/th?id=OIP.Q8t-bmJON5ValbWW0H30IgHaFj&pid=15.1&P=0&w=235&h=177").into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textBrand;
        TextView textPrice;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textBrand = itemView.findViewById(R.id.brand);
            textPrice = itemView.findViewById(R.id.price);
        }
    }

}

