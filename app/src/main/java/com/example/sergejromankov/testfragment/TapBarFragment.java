package com.example.sergejromankov.testfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sergejromankov.testfragment.Contacts.View.ContactsFragment;
import com.example.sergejromankov.testfragment.Contacts.Models.ContactsInitModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sergejromankov on 25.11.2017.
 */

public class TapBarFragment extends Fragment implements View.OnClickListener {
    Button btn1;
    Button btn2;

    ContactsFragment fragmentOne;
    ContactsFragment fragmentTwo;

    TapBarItemFragment fragmentOneItem;
    TapBarItemFragment fragmentTwoItem;


    TapBarItemFragment currentFragment;

    public static TapBarFragment instance(ArrayList<TapFragmentItemModel> list){
        TapBarFragment f = new TapBarFragment();
        Bundle bundle = new Bundle();
        bundle.putString("", String.valueOf(list));
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tap_bar, container, false);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.button2);
        setRetainInstance(true);

        Bundle bundle = getArguments();
        if(bundle != null){

        }



        if(savedInstanceState == null)
        {

            ContactsInitModel contactsModel1 = new ContactsInitModel();
            ContactsInitModel contactsModel2 = new ContactsInitModel();

            contactsModel1.color = R.color.colorPrimary;
            contactsModel2.color = R.color.colorAccent;
            // Create Fragment
            fragmentOne = ContactsFragment.instance(contactsModel1);
            fragmentTwo = ContactsFragment.instance(contactsModel2);

            fragmentOneItem = TapBarItemFragment.instance(R.color.colorPrimaryDark);
            fragmentTwoItem = TapBarItemFragment.instance(R.color.colorAccent);

            _addFragment(fragmentOneItem, "1");
            _addFragment(fragmentTwoItem, "2");

            currentFragment = fragmentTwoItem;

            _addFragment(fragmentOne, fragmentOneItem);
            _addFragment(fragmentTwo, fragmentTwoItem);

        }


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);


        return view;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    public void onBackPressed(){
        currentFragment.getChildFragmentManager().popBackStack();
    }

    public int getBackStackEntryCount(){
        int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();
        if(count == 1){
            return 0;
        }
        return count;
    }


    public void addFragment(Fragment fragment){
        _addFragment(fragment, currentFragment);
    }

    private void _addFragment(Fragment fragment, Fragment currentFragment){
        FragmentTransaction transaction = currentFragment.getChildFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainer,fragment, fragment.getClass().getName());
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commit();
    }


    private void _addFragment(Fragment fragment, String s){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainer,fragment);
        transaction.commitNow();
    }

    private void _addFragmentWithParent(Fragment fragment, Fragment parent){
        FragmentTransaction transaction = parent.getFragmentManager().beginTransaction();
        transaction.add(R.id.fragmentContainer,fragment);
        transaction.commit();
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.show(fragment);
        transaction.commit();
    }

    private void hideFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.hide(fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        if(v == btn1)
        {
            currentFragment = fragmentOneItem;
            showFragment(fragmentOneItem);
            hideFragment(fragmentTwoItem);
        }

        if(v == btn2){
            currentFragment = fragmentTwoItem;
            showFragment(fragmentTwoItem);
            hideFragment(fragmentOneItem);
        }

    }


}
