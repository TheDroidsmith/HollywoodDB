package com.droidsmith.hollywooddb.ui.main.fragments.tv;


import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.ui.base.BasePresenter;

import javax.inject.Inject;

public class TVPresenterImp extends BasePresenter<TVContract.TVView> implements TVContract.TVPresenter {




    @Inject
    public NetworkManager networkManager;

    @Inject
    public TVPresenterImp(TVContract.TVView view, NetworkManager networkManager) {
        super(view);
        this.networkManager = networkManager;
    }



}
