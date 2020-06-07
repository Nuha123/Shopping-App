package com.example.nuhavarier.shopping_app.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.nuhavarier.shopping_app.fragments.clothing.CapsFragment;
import com.example.nuhavarier.shopping_app.fragments.clothing.ShortsFragment;
import com.example.nuhavarier.shopping_app.fragments.clothing.TShirtFragment;
import com.example.nuhavarier.shopping_app.fragments.clothing.TnJFragment;
import com.example.nuhavarier.shopping_app.fragments.clothing.TrackPantsFragment;

public class ClothingAdapter extends FragmentStatePagerAdapter {
    Context mContext;
    int tabCount;

    TShirtFragment tShirtFragment;
    TrackPantsFragment trackPantsFragment;
    ShortsFragment shortsFragment;
    TnJFragment tnJFragment;
    CapsFragment capsFragment;
    public ClothingAdapter(Context mContext, FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        this.mContext=mContext;
        this.tabCount=tabCount;
        Log.d("testing","ClothingAdapter Clothing");
        if (tShirtFragment == null) tShirtFragment = TShirtFragment.newInstance(null,null);
        if (trackPantsFragment == null) trackPantsFragment = TrackPantsFragment.newInstance(null,null);
        if (shortsFragment == null) shortsFragment = ShortsFragment.newInstance(null,null);
        if (tnJFragment == null) tnJFragment = TnJFragment.newInstance(null,null);
        if (capsFragment == null) capsFragment = CapsFragment.newInstance(null,null);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return tShirtFragment;
        }else if(position==1){
            return trackPantsFragment;
        }else if(position==2){
            return shortsFragment;
        }else if(position==3){
            return tnJFragment;
        }else if(position==4){
            return capsFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        //Do NOTHING;
    }
}
