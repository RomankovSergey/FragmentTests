package com.example.sergejromankov.testfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sergejromankov on 25.11.2017.
 */

public class TapBarFragment extends Fragment implements View.OnClickListener {
    Button btn1;
    Button btn2;

    FragmentColor fragmentOne;
    FragmentColor fragmentTwo;


    public static TapBarFragment instance(){
        TapBarFragment f = new TapBarFragment();
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tap_bar, container, false);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.button2);

        // Create Fragment
        fragmentOne = FragmentColor.instance(R.color.colorPrimary);
        fragmentTwo = FragmentColor.instance(R.color.colorAccent);

        addFragment(fragmentOne);
        addFragment(fragmentTwo);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        return view;
    }


    private void addFragment(Fragment fragment){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainer,fragment);
        transaction.commit();
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.show(fragment);
        transaction.commit();
    }

    private void hideFragment(Fragment fragment){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.hide(fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        if(v == btn1)
        {
            showFragment(fragmentOne);
            hideFragment(fragmentTwo);
        }

        if(v == btn2){
            showFragment(fragmentTwo);
            hideFragment(fragmentOne);
        }

    }
}
