package com.example.nuhavarier.shopping_app.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nuhavarier.shopping_app.R;
import com.example.nuhavarier.shopping_app.fragments.HomeFragment;

public class ImageAdapter extends PagerAdapter {
    Context mContext;

    public ImageAdapter(Context mContext) {
        this.mContext=mContext;
    }

    @Override
    public int getCount() {
        return sliderImageId.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView=new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(sliderImageId[position]);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ImageView) object);
    }

    private int[] sliderImageId = new int[]{
            R.drawable.iscloth2,R.drawable.isshoes2,R.drawable.isequip1,R.drawable.iscloth1,R.drawable.shoes,R.drawable.isequip
    };

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}
