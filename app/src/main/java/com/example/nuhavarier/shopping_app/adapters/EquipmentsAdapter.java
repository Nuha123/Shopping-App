package com.example.nuhavarier.shopping_app.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.nuhavarier.shopping_app.fragments.equipments.BasketballFragment;
import com.example.nuhavarier.shopping_app.fragments.equipments.CricketFragment;
import com.example.nuhavarier.shopping_app.fragments.equipments.FootballFragment;
import com.example.nuhavarier.shopping_app.fragments.equipments.GymFragment;
import com.example.nuhavarier.shopping_app.fragments.equipments.TennisFragment;

public class EquipmentsAdapter extends FragmentStatePagerAdapter {
    Context mContext;
    int tabCount;

    public EquipmentsAdapter(Context mContext, FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        this.mContext=mContext;
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new CricketFragment();
        }else if(position==1){
            return new FootballFragment();
        }else if(position==2){
            return new TennisFragment();
        }else if(position==3){
            return new BasketballFragment();
        }else if(position==4){
            return new GymFragment();
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
