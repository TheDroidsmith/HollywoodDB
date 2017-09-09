package com.droidsmith.hollywooddb.ui.home;


import com.droidsmith.hollywooddb.ui.home.MainPresenter;
import com.droidsmith.hollywooddb.ui.home.MainView;

import javax.inject.Inject;

public class MainPresenterImp implements MainPresenter {

    private MainView view;

    @Inject
    public MainPresenterImp(MainView view) {
        this.view = view;
    }

}
