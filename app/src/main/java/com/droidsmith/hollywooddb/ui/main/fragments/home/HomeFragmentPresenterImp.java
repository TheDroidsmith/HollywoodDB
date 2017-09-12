package com.droidsmith.hollywooddb.ui.main.fragments.home;


import android.util.Log;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;

import javax.inject.Inject;


public class HomeFragmentPresenterImp implements HomeFragmentPresenter {

    private HomeFragmentView view;
    private NetworkManager networkManager;

    @Inject
    public HomeFragmentPresenterImp(HomeFragmentView view, NetworkManager networkManager) {
        this.view = view;
        this.networkManager = networkManager;
    }


    @Override
    public void fetchPopularMoviesList() {
        //view.updatePopularMovieList(networkManager.callPopularMovies());
    }

    @Override
    public void fetchPopularTVList() {
        //view.updatePopularTVList(networkManager.callPopularTV());
    }

    @Override
    public void fetchTopTVList() {
        networkManager.callTopTV();
    }
}
