package com.example.nuhavarier.shopping_app.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.nuhavarier.shopping_app.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import static com.example.nuhavarier.shopping_app.activities.MainActivity.cartlist;

public class ItemDetailsActivity extends AppCompatActivity {
    RelativeLayout description;
    RelativeLayout reviews;
    RelativeLayout offers;
    ExpandableLayout expDescription;
    ExpandableLayout expReviews;
    ExpandableLayout expOffers;
    FloatingActionButton addToCart;
//    MyTees tees ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        description = findViewById(R.id.description);
        reviews = findViewById(R.id.reviews);
        offers = findViewById(R.id.offers);
        expDescription = findViewById(R.id.exp_description);
        expReviews = findViewById(R.id.exp_reviews);
        expOffers = findViewById(R.id.exp_offers);
        addToCart = findViewById(R.id.add_to_cart);

//        Cart cart = new Cart();
//        cart.setType(MyTees.class.getSimpleName());
//
//        cartlist.add(cart);
    description.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            expDescription.toggle();
        }
    });

    reviews.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            expReviews.toggle();
        }
    });

    offers.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            expOffers.toggle();
        }
    });

    }
}
