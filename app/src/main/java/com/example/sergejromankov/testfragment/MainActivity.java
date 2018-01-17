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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        tapBarFragment = TapBarFragment.instance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, tapBarFragment);
        fragmentTransaction.commitNow();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
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
        tapBarFragment.addFragment(fragment);
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
