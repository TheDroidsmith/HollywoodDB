package com.droidsmith.hollywooddb.data.manager;



import com.droidsmith.hollywooddb.data.remote.request.TMDBInterface;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TopTVResponse;

import io.reactivex.Observable;

public class NetworkManagerImp implements NetworkManager{

    private final static String API_KEY = "83f458fcc7c923112569dd3faec43ec7";
    private TMDBInterface tmdbInterface;

    public NetworkManagerImp(TMDBInterface tmdbInterface) {
        this.tmdbInterface = tmdbInterface;
    }

    @Override
    public Observable<PopularMoviesResponse> apiPopularMovies(){
        return tmdbInterface.getPopularMovies(API_KEY);
    }

    @Override
    public Observable<PopularTVResponse> apiPopularTV(){
        return tmdbInterface.getPopularTV(API_KEY);
    }

    @Override
    public Observable<TopTVResponse> apiTopTV() {
        return tmdbInterface.getTopRatedTV(API_KEY);
    }


}
