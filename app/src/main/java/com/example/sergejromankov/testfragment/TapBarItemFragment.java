package com.example.sergejromankov.testfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergejromankov.testfragment.Contacts.Models.ContactsInitModel;
import com.example.sergejromankov.testfragment.Contacts.View.ContactsFragment;

/**
 * Created by sergejromankov on 15.01.2018.
 */

public class TapBarItemFragment extends Fragment {

    static String COLOR = "COLOR";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tap_bar_fragment_item, container, false);
        Bundle bundle = getArguments();
        setRetainInstance(true);
        int color = bundle.getInt(COLOR);
        view.setBackgroundResource(color);
        return view;
    }


    static public TapBarItemFragment instance(int color){
        TapBarItemFragment fragment = new TapBarItemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(COLOR, color);
        fragment.setArguments(bundle);
        return fragment;
    }

}
