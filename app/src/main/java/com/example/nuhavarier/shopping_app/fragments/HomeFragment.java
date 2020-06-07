package com.example.nuhavarier.shopping_app.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nuhavarier.shopping_app.R;
import com.example.nuhavarier.shopping_app.adapters.ImageAdapter;
import com.example.nuhavarier.shopping_app.listeners.OnFragmentInteractionListener;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    Handler handler;
    Runnable imageSlider;
    ViewPager viewPager;
    Context mContext;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Home");
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        viewPager=view.findViewById(R.id.view_pager);
        ImageView clothing = view.findViewById(R.id.clothing);
        ImageView shoes = view.findViewById(R.id.shoes);
        ImageView equipments = view.findViewById(R.id.equipments);

        ImageAdapter adapterView = new ImageAdapter(mContext);
        viewPager.setAdapter(adapterView);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
        final int totalImage=adapterView.getCount();
        handler=new Handler();
        imageSlider=new Runnable() {
            @Override
            public void run() {
                if(viewPager.getCurrentItem()<totalImage-1){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }else {
                    viewPager.setCurrentItem(0);
                }

                handler.postDelayed(imageSlider,2000);
            }
        };
        handler.postDelayed(imageSlider,2000);

        clothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main,new ClothingFragment());
                fragmentTransaction.commit();
            }
        });
        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main,new ShoesFragment());
                fragmentTransaction.commit();
            }
        });
        equipments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main,new EquipmentsFragment());
                fragmentTransaction.commit();
            }
        });
        // Inflate the layout for this fragment
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
        this.mContext=context;
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

    private class SliderTimer extends TimerTask {
        @Override
        public void run() {
        }
    }
}
