package com.droidsmith.hollywooddb.ui.main.fragments.movies;


import android.util.Log;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.LatestMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.NowPlayingMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.TopMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.UpcomingMoviesResponse;
import com.droidsmith.hollywooddb.ui.base.BasePresenter;
import com.droidsmith.hollywooddb.utility.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MoviesPresenterImp extends BasePresenter<MoviesContract.MoviesView> implements MoviesContract.MoviesPresenter{

    @Inject
    public NetworkManager networkManager;

    @Inject
    SchedulerProvider schedulerProvider;

    @Inject
    public MoviesPresenterImp(MoviesContract.MoviesView view, NetworkManager networkManager,
                              SchedulerProvider schedulerProvider) {
        super(view);
        this.networkManager = networkManager;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public void fetchLatestMoviesList() {
        addDisposable(
                networkManager.apiLatestMovies()
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribeWith(new DisposableSingleObserver<LatestMoviesResponse>() {
                            @Override
                            public void onSuccess(LatestMoviesResponse latestMoviesResponse) {
                                view.updateNewestMoviesList(latestMoviesResponse.results);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        }));

    }

    @Override
    public void fetchTopRatedMoviesList() {
        addDisposable(
                networkManager.apiTopMovies()
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribeWith(new DisposableSingleObserver<TopMoviesResponse>() {
                            @Override
                            public void onSuccess(TopMoviesResponse topMoviesResponse) {
                                view.updateTopRatedMoviesList(topMoviesResponse.results);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        }));
    }

    @Override
    public void fetchUpcomingMoviesList() {
        addDisposable(
                networkManager.apiUpcomingMovies()
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribeWith(new DisposableSingleObserver<UpcomingMoviesResponse>() {
                            @Override
                            public void onSuccess(UpcomingMoviesResponse upcomingMoviesResponse) {
                                view.updateUpcomingMoviesList(upcomingMoviesResponse.results);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        }));

    }

    @Override
    public void fetchNowPlayingMoviesList() {
        addDisposable(
                networkManager.apiNowPlayingMovies()
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribeWith(new DisposableSingleObserver<NowPlayingMoviesResponse>() {
                            @Override
                            public void onSuccess(NowPlayingMoviesResponse nowPlayingMoviesResponse) {
                                view.updateNowPlayingMoviesList(nowPlayingMoviesResponse.results);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        }));
    }



}
