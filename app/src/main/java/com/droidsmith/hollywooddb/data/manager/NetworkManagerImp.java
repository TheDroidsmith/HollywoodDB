package com.droidsmith.hollywooddb.data.manager;



import com.droidsmith.hollywooddb.data.remote.request.TMDBService;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.LatestMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.NowPlayingMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.TopMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.UpcomingMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.AiringTodayResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.OnTheAirResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TopTVResponse;

import io.reactivex.Observable;
import io.reactivex.Single;

public class NetworkManagerImp implements NetworkManager{

    private final static String API_KEY = "83f458fcc7c923112569dd3faec43ec7";
    private TMDBService tmdbService;

    public NetworkManagerImp(TMDBService tmdbService) {
        this.tmdbService = tmdbService;
    }




    //movies
    @Override
    public Observable<PopularMoviesResponse> apiPopularMovies(){
        return tmdbService.getPopularMovies(API_KEY);
    }

    @Override
    public Observable<LatestMoviesResponse> apiLatestMovies(){
        //TODO: remove this
        return tmdbService.getLatestMovies(API_KEY);
    }

    @Override
    public Observable<TopMoviesResponse> apiTopMovies() {
        return tmdbService.getTopMovies(API_KEY);
    }

    @Override
    public Observable<UpcomingMoviesResponse> apiUpcomingMovies() {
        return tmdbService.getUpcomingMovies(API_KEY);
    }

    @Override
    public Observable<NowPlayingMoviesResponse> apiNowPlayingMovies() {
        return tmdbService.getNowPlayingMovies(API_KEY);
    }

    @Override
    public Single<MovieDetails> apiMovieDetails(Integer movieID) {
        return tmdbService.getMovieDetails(movieID, API_KEY);
    }


    //tv
    @Override
    public Observable<TopTVResponse> apiTopTV() {
        return tmdbService.getTopTV(API_KEY);
    }

    @Override
    public Observable<PopularTVResponse> apiPopularTV(){
        return tmdbService.getPopularTV(API_KEY);
    }

    @Override
    public Observable<AiringTodayResponse> apiAiringTodayTV() {
        return tmdbService.getAiringTodayTV(API_KEY);
    }

    @Override
    public Observable<OnTheAirResponse> apiOnTheAirTV() {
        return tmdbService.getOnTheAirTV(API_KEY);

    }


}
