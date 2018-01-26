package com.example.sergejromankov.testfragment;

import android.app.Fragment;
import android.graphics.Bitmap;

/**
 * Created by sergejromankov on 26.01.2018.
 */

public class TapFragmentItemModel {
    private Fragment fragment;
    private Bitmap bitmapActive;
    private Bitmap bitmapAInActive;
    private String title;


    public TapFragmentItemModel(Fragment fragment, Bitmap bitmapActive, Bitmap bitmapAInActive, String title) {
        this.fragment = fragment;
        this.bitmapActive = bitmapActive;
        this.bitmapAInActive = bitmapAInActive;
        this.title = title;
    }


    public Fragment getFragment() {
        return fragment;
    }

    public Bitmap getBitmapActive() {
        return bitmapActive;
    }

    public Bitmap getBitmapAInActive() {
        return bitmapAInActive;
    }

    public String getTitle() {
        return title;
    }
}
