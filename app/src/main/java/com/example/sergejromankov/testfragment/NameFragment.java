package com.example.sergejromankov.testfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sergejromankov on 25.11.2017.
 */

public class NameFragment extends Fragment {

    final private static String KEY_NAME = "KEY_NAME";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name, container, false);
        TextView textView = view.findViewById(R.id.textView);
        this.getTargetFragment();
        Bundle bundle = getArguments();
        if (bundle.getString(KEY_NAME) != null)
            textView.setText(bundle.getString(KEY_NAME));

        return view;
    }

   public static Fragment instance(String name){
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NAME, name);
        NameFragment fragment = new NameFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
