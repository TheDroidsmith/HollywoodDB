package com.droidsmith.hollywooddb.data.manager;


import android.util.Log;

import com.droidsmith.hollywooddb.data.remote.request.TMDBInterface;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMovies;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResults;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTV;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResults;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TopTV;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeFragmentView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkManagerImp implements NetworkManager{

    private final static String API_KEY = "83f458fcc7c923112569dd3faec43ec7";
    private TMDBInterface tmdbInterface; //maybe this should go into the network manager?

    public NetworkManagerImp(TMDBInterface tmdbInterface) {
        this.tmdbInterface = tmdbInterface;
    }

    @Override
    public void callPopularMovies(){
        Call<PopularMovies> mCall = tmdbInterface.doGetPopularMovies(API_KEY);
        mCall.enqueue(new Callback<PopularMovies>() {
            @Override
            public void onResponse(Call<PopularMovies> call, Response<PopularMovies> response) {
                ArrayList<PopularMoviesResults> resultList = (ArrayList<PopularMoviesResults>) response.body().results;
                Log.d("MainPresenter","Popular Movies Results: " + resultList.get(0).title);

            }
            @Override
            public void onFailure(Call<PopularMovies> call, Throwable t) {
                call.cancel();
            }
        });

    }


    @Override
    public void callPopularTV(){
        final ArrayList<PopularTVResults> resultList;
        Call<PopularTV> call = tmdbInterface.doGetPopularTV(API_KEY);
        call.enqueue(new Callback<PopularTV>() {
            @Override
            public void onResponse(Call<PopularTV> call, Response<PopularTV> response) {
                //resultList = (ArrayList<PopularTVResults>) response.body().results;
                //Log.d("MainPresenter","Popular TV Results: " + resultList.get(0).name);


            }
            @Override
            public void onFailure(Call<PopularTV> call, Throwable t) {
                call.cancel();
            }
        });
    }


    public void callTopTV(){

        Call<TopTV> call = tmdbInterface.doGetTopRatedTV(API_KEY);
        call.enqueue(new Callback<TopTV>() {
            @Override
            public void onResponse(Call<TopTV> call, Response<TopTV> response) {
                //ArrayList<TopTVResults> resultList = (ArrayList<TopTVResults>) response.body().results;
                Log.d("MainPresenter","*********************SUCCESS**************");
            }
            @Override
            public void onFailure(Call<TopTV> call, Throwable t) {
                call.cancel();
            }
        });
    }

}
