package com.example.sergejromankov.testfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sergejromankov on 25.11.2017.
 */

public class FragmentColor extends Fragment {


    final static String KEY_COLOR = "KEY_COLOR";


    static FragmentColor instance(int color){
        FragmentColor f = new FragmentColor();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_COLOR, color);
        f.setArguments(bundle);
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);

        Bundle bundle = getArguments();
        if(bundle.get(KEY_COLOR) != null)
            view.setBackgroundResource(bundle.getInt(KEY_COLOR));

        return view;
    }
}
