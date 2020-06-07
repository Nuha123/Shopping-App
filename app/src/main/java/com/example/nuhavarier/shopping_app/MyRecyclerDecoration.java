package com.example.nuhavarier.shopping_app;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MyRecyclerDecoration extends RecyclerView.ItemDecoration {
    private int itemSSpace;

    public MyRecyclerDecoration(int space) {
        this.itemSSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = itemSSpace;
        outRect.bottom = itemSSpace;
        outRect.left = itemSSpace;
        outRect.right = itemSSpace;

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = itemSSpace+itemSSpace;
        }

        if (parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount()-1) {
            outRect.bottom = itemSSpace+itemSSpace;
        }
    }
}
