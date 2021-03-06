package com.example.nuhavarier.shopping_app.fragments.clothing;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nuhavarier.shopping_app.MyRecyclerDecoration;
import com.example.nuhavarier.shopping_app.R;
import com.example.nuhavarier.shopping_app.activities.MainActivity;
import com.example.nuhavarier.shopping_app.adapters.Clothing1Adapter.TShirtAdapter;
import com.example.nuhavarier.shopping_app.listeners.OnFragmentInteractionListener;

public class TShirtFragment extends Fragment {
    Context context;
    MainActivity mainActivity;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TShirtFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TShirtFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TShirtFragment newInstance(String param1, String param2) {
        TShirtFragment fragment = new TShirtFragment();
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
        // Inflate the layout for this fragment
          View view=inflater.inflate(R.layout.fragment_tshirt, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recycler_view);
        TShirtAdapter tShirtAdapter=new TShirtAdapter(context);
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(tShirtAdapter);
        recyclerView.addItemDecoration(new MyRecyclerDecoration(10));
        Log.d("testing","T Shirt");
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
        super.onAttach(context);
        this.context=context;
        this.mainActivity=(MainActivity) context;
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
