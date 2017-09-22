package com.droidsmith.hollywooddb.data.manager;


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
import io.reactivex.disposables.Disposable;

public interface NetworkManager {

    //movies
    Observable<PopularMoviesResponse> apiPopularMovies();

    Observable<LatestMoviesResponse> apiLatestMovies();//TODO: remove this

    Observable<TopMoviesResponse> apiTopMovies();

    Observable<UpcomingMoviesResponse> apiUpcomingMovies();

    Observable<NowPlayingMoviesResponse> apiNowPlayingMovies();

    Single<MovieDetails> apiMovieDetails(Integer movieID);


    //tv
    Observable<TopTVResponse> apiTopTV();

    Observable<PopularTVResponse> apiPopularTV();

    Observable<AiringTodayResponse> apiAiringTodayTV();

    Observable<OnTheAirResponse> apiOnTheAirTV();
}
