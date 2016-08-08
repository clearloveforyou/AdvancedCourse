package com.hsl.taole.worksample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NBAFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NBAFragment extends Fragment {



    public NBAFragment() {
        // Required empty public constructor
    }


    public static NBAFragment newInstance() {
        NBAFragment fragment = new NBAFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nba, container, false);
    }

}
