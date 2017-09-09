package com.droidsmith.hollywooddb.presenter;


import android.util.Log;

import com.droidsmith.hollywooddb.view.activities.views.MainView;

import javax.inject.Inject;

public class MainPresenterImp implements MainPresenter {

    private MainView view;

    @Inject
    public MainPresenterImp(MainView view) {
        this.view = view;
    }

}
