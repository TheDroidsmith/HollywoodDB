package com.droidsmith.hollywooddb.ui.home;


import android.util.Log;

import com.droidsmith.hollywooddb.data.remote.request.TMDBInterface;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMovies;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Result;
import com.droidsmith.hollywooddb.ui.home.MainPresenter;
import com.droidsmith.hollywooddb.ui.home.MainView;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImp implements MainPresenter {
    private MainView view;

    @Inject
    public MainPresenterImp(MainView view) {
        this.view = view;
    }



}
