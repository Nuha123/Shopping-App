package com.example.nuhavarier.shopping_app.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nuhavarier.shopping_app.R;
import com.example.nuhavarier.shopping_app.adapters.ClothingAdapter;
import com.example.nuhavarier.shopping_app.listeners.OnFragmentInteractionListener;

public class ClothingFragment extends Fragment {
    Context mContext;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    public ClothingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClothingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClothingFragment newInstance(String param1, String param2) {
        ClothingFragment fragment = new ClothingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Clothing");
        // Inflate the layout for this fragment
        Log.d("check","onCreateView Working");
        View view = inflater.inflate(R.layout.fragment_clothing, container, false);
        final TabLayout tabLayout=view.findViewById(R.id.tab_layout);
        final ViewPager viewPager=view.findViewById(R.id.cl_container);
        tabLayout.addTab(tabLayout.newTab().setText("T-Shirt"));
        tabLayout.addTab(tabLayout.newTab().setText("Track Pants"));
        tabLayout.addTab(tabLayout.newTab().setText("Shorts"));
        tabLayout.addTab(tabLayout.newTab().setText("TrackSuits and Jackets"));
        tabLayout.addTab(tabLayout.newTab().setText("Caps"));
        Log.d("testing","OnCreateView Clothing");
//        viewPager.setOffscreenPageLimit(1);
        ClothingAdapter clothingAdapter=new ClothingAdapter(mContext,getChildFragmentManager(),5);
        viewPager.setAdapter(clothingAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabLayout.setScrollPosition(position,positionOffset,true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        mContext=context;
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
