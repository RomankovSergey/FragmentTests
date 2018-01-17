package com.example.sergejromankov.testfragment.Main;

import android.support.v4.app.Fragment;

/**
 * Created by sergejromankov on 26.12.2017.
 */

public interface MainRouter {
    void addFragment(Fragment fragment);
    void addFragmentToTapBar(Fragment fragment);
}
