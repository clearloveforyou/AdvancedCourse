package com.hsl.android.qianfeng.advancedcourse.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsl.android.qianfeng.advancedcourse.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityFragment extends Fragment {


    public static ActivityFragment newInstance() {

        Bundle args = new Bundle();

        ActivityFragment fragment = new ActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity, container, false);
    }

}
