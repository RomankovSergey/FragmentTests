package com.example.sergejromankov.testfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sergejromankov.testfragment.Main.MainRouter;

public class MainActivity extends AppCompatActivity implements MainRouter {
    TextView textView;
    TapBarFragment tapBarFragment;
    boolean isStartActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        if(savedInstanceState == null){
            tapBarFragment = TapBarFragment.instance();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragmentContainer, tapBarFragment);
            fragmentTransaction.commitNow();
        }else{
            tapBarFragment = (TapBarFragment) getLastCustomNonConfigurationInstance();
        }
    }



    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        isStartActivity = true;
        super.onStart();
    }

    @Override
    protected void onStop() {
        isStartActivity = false;
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }


    public TapBarFragment onRetainCustomNonConfigurationInstance (){
        return tapBarFragment;
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
    // MainRouter

    @Override
    public void addFragment(android.support.v4.app.Fragment fragment) {
        String s = fragment.getClass().getName();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, fragment, fragment.getClass().getName());
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    @Override
    public void addFragmentToTapBar(android.support.v4.app.Fragment fragment) {

        if(!isStartActivity){
            return;
        }

        if(tapBarFragment != null)
        {
            tapBarFragment.addFragment(fragment);
        }
    }

    @Override
    public void onBackPressed() {
        //Обработка TAPBAR
        int count = tapBarFragment.getBackStackEntryCount();
        if(count != 0){
            tapBarFragment.onBackPressed();
        }else{
            super.onBackPressed();
        }

    }
}
