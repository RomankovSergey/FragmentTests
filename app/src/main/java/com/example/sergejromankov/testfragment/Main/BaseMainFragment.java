package com.example.sergejromankov.testfragment.Main;

import android.app.ProgressDialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.Toast;

import com.example.sergejromankov.testfragment.Main.General.BaseFragment;
import com.example.sergejromankov.testfragment.Main.General.BasePresenter;
import com.example.sergejromankov.testfragment.MainActivity;


/**
 * Created by sergejromankov on 26.12.2017.
 */


public abstract class BaseMainFragment extends BaseFragment implements BaseMainView {


    @Override
    public void showError(@StringRes int message) {
        Toast.makeText(getContext(), getString(message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        MainActivity mainActivity = (MainActivity) getActivity();
        //noinspection unchecked
        getPresenter().setRouter(mainActivity);
        //noinspection unchecked
        getPresenter().setView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //noinspection unchecked
        getPresenter().setRouter(null);
    }

    @Override
    public void showNewMessagesNotification() {
        //noinspection ConstantConditions
    }


    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        getPresenter().onStop();

    }

    ProgressDialog progressDialog;



    public void showMessageToast(String message) {
        if(this.getActivity() != null){
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }
    }

    public void showMessageToast(@StringRes int stringRes) {
        if(this.getActivity() != null) {
            Toast.makeText(getActivity(), getString(stringRes), Toast.LENGTH_SHORT).show();
        }
    }


    public void applyStyle() {
    }


    @NonNull
    protected abstract BasePresenter getPresenter();
}
