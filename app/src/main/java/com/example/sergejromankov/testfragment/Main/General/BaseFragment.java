package com.example.sergejromankov.testfragment.Main.General;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.sergejromankov.testfragment.Contacts.Data.ContactsPresenter;
import com.example.sergejromankov.testfragment.MainActivity;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by sergejromankov on 26.12.2017.
 */

public abstract class BaseFragment extends Fragment {

    private static final AtomicInteger lastFragmentId = new AtomicInteger(0);
    private final int fragmentId;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }




    public BaseFragment() {
        fragmentId = lastFragmentId.incrementAndGet();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        // add View
        //noinspection unchecked
        getPresenter().setView(this);

        // add Router
        MainActivity mainActivity = (MainActivity) getActivity();
        //noinspection unchecked
        getPresenter().setRouter(mainActivity);
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().isStart = true;
        getPresenter().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        getPresenter().isStart = false;
        getPresenter().onStop();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //noinspection unchecked
        getPresenter().setRouter(null);
    }

    public String getFragmentName() {
        return Long.toString(fragmentId);
    }

    @NonNull
    protected abstract BasePresenter getPresenter();
}
