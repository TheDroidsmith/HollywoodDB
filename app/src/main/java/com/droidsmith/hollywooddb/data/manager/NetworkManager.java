package com.droidsmith.hollywooddb.data.manager;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.LatestMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.NowPlayingMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.TopMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.UpcomingMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.people.CreditResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.AiringTodayResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.OnTheAirResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShowDetails;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TopTVResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public interface NetworkManager {

    //movies
    Single<PopularMoviesResponse> apiPopularMovies();

    Single<LatestMoviesResponse> apiLatestMovies();//TODO: remove this

    Single<TopMoviesResponse> apiTopMovies();

    Single<UpcomingMoviesResponse> apiUpcomingMovies();

    Single<NowPlayingMoviesResponse> apiNowPlayingMovies();

    Single<MovieDetails> apiMovieDetails(Integer movieID);

    Single<CreditResponse> apiMovieCredits(Integer movieID);


    //tv
    Single<TopTVResponse> apiTopTV();

    Single<PopularTVResponse> apiPopularTV();

    Single<AiringTodayResponse> apiAiringTodayTV();

    Single<OnTheAirResponse> apiOnTheAirTV();

    Single<TVShowDetails> apiTVShowDetails(Integer tvID);

    Single<CreditResponse> apiTVCredits(Integer movieID);

}
