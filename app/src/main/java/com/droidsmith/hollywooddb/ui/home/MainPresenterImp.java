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
    private final static String API_KEY = "83f458fcc7c923112569dd3faec43ec7";
    private MainView view;
    private TMDBInterface movieInterface; //maybe this should go into the network manager?

    @Inject
    public MainPresenterImp(MainView view, TMDBInterface movieInterface) {
        this.view = view;
        this.movieInterface = movieInterface;
    }

    @Override
    public void checkNetworkCall(){

        //Movie Calls
        Call<PopularMovies> mCall = movieInterface.doGetPopularMovies(API_KEY);
        mCall.enqueue(new Callback<PopularMovies>() {
            @Override
            public void onResponse(Call<PopularMovies> call, Response<PopularMovies> response) {

                ArrayList<Result> resultList = (ArrayList<Result>) response.body().results;
                Log.d("MainPresenter","Results: " + resultList.get(0).title);

            }
            @Override
            public void onFailure(Call<PopularMovies> call, Throwable t) {
                call.cancel();
            }
        });

    }

}
