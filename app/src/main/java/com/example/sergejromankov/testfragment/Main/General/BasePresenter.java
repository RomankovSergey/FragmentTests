package com.example.sergejromankov.testfragment.Main.General;

/**
 * Created by sergejromankov on 26.12.2017.
 */

public abstract class BasePresenter<View, Router> {
    private View view;
    private Router router;
    public boolean isStart;


    public abstract void init();

    public abstract void onStart();

    public abstract void onStop();

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }
}
