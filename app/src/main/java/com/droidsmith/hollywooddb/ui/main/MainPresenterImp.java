package com.droidsmith.hollywooddb.ui.main;


import javax.inject.Inject;

public class MainPresenterImp implements MainContract.MainPresenter {

    private MainContract.MainView view;

    @Inject
    public MainPresenterImp(MainContract.MainView view) {
        this.view = view;
    }



}
