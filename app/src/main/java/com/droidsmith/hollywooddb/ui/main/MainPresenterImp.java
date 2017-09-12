package com.droidsmith.hollywooddb.ui.main;


import javax.inject.Inject;

public class MainPresenterImp implements MainPresenter {
    private MainView view;

    @Inject
    public MainPresenterImp(MainView view) {
        this.view = view;
    }



}
