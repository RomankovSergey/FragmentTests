package com.example.sergejromankov.testfragment.Main;

import android.support.annotation.StringRes;

/**
 * Created by sergejromankov on 26.12.2017.
 */

public interface BaseMainView {
    void showError(@StringRes int message);
    void showNewMessagesNotification();
}

