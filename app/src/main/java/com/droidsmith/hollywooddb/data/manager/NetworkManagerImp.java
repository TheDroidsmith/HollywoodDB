package com.droidsmith.hollywooddb.data.manager;



import com.droidsmith.hollywooddb.data.remote.request.TMDBInterface;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.LatestMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.NowPlayingMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.TopMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.UpcomingMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.AiringTodayResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.OnTheAirResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TopTVResponse;

import io.reactivex.Observable;

public class NetworkManagerImp implements NetworkManager{

    private final static String API_KEY = "83f458fcc7c923112569dd3faec43ec7";
    private TMDBInterface tmdbInterface;

    public NetworkManagerImp(TMDBInterface tmdbInterface) {
        this.tmdbInterface = tmdbInterface;
    }




    //movies
    @Override
    public Observable<PopularMoviesResponse> apiPopularMovies(){
        return tmdbInterface.getPopularMovies(API_KEY);
    }

    @Override
    public Observable<LatestMoviesResponse> apiLatestMovies(){
        //TODO: remove this
        return tmdbInterface.getLatestMovies(API_KEY);
    }

    @Override
    public Observable<TopMoviesResponse> apiTopMovies() {
        return tmdbInterface.getTopMovies(API_KEY);
    }

    @Override
    public Observable<UpcomingMoviesResponse> apiUpcomingMovies() {
        return tmdbInterface.getUpcomingMovies(API_KEY);
    }

    @Override
    public Observable<NowPlayingMoviesResponse> apiNowPlayingMovies() {
        return tmdbInterface.getNowPlayingMovies(API_KEY);
    }


    //tv
    @Override
    public Observable<TopTVResponse> apiTopTV() {
        return tmdbInterface.getTopTV(API_KEY);
    }

    @Override
    public Observable<PopularTVResponse> apiPopularTV(){
        return tmdbInterface.getPopularTV(API_KEY);
    }

    @Override
    public Observable<AiringTodayResponse> apiAiringTodayTV() {
        return tmdbInterface.getAiringTodayTV(API_KEY);
    }

    @Override
    public Observable<OnTheAirResponse> apiOnTheAirTV() {
        return tmdbInterface.getOnTheAirTV(API_KEY);

    }


}
