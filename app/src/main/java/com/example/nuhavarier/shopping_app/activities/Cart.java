package com.example.nuhavarier.shopping_app.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nuhavarier.shopping_app.R;
import com.example.nuhavarier.shopping_app.adapters.CartAdapter;

import java.util.List;

import static com.example.nuhavarier.shopping_app.activities.MainActivity.cartlist;

public class Cart extends AppCompatActivity {

    List<Cart> cartCompletelist = cartlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setTitle("Cart");
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cart);
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        CartAdapter cartAdapter=new CartAdapter();
        recyclerView.setAdapter(cartAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
