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

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MoviesPresenterImp extends BasePresenter<MoviesContract.MoviesView> implements MoviesContract.MoviesPresenter{

    @Inject
    public NetworkManager networkManager;


    @Inject
    public MoviesPresenterImp(MoviesContract.MoviesView view, NetworkManager networkManager) {
        super(view);
        this.networkManager = networkManager;
    }

    @Override
    public void fetchLatestMoviesList() {
        addDisposable(
                networkManager.apiLatestMovies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<LatestMoviesResponse>() {
                            @Override
                            public void onNext(LatestMoviesResponse latestMoviesResponse) {
                                view.updateNewestMoviesList(latestMoviesResponse.results);
                                for (Movie movie : latestMoviesResponse.results) {
                                    Log.d("Latest Movies ---->", "Movie ---- " + movie.title);
                                }
                            }
                            @Override
                            public void onError(Throwable e) {
                                //Log.d("On TV OnError", "ERROR!!");
                            }
                            @Override
                            public void onComplete() {
                                //Log.d("On TV Success", "Success!!");
                            }
                        }));

    }

    @Override
    public void fetchTopRatedMoviesList() {
        addDisposable(
                networkManager.apiTopMovies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<TopMoviesResponse>() {
                            @Override
                            public void onNext(TopMoviesResponse topMoviesResponse) {
                                view.updateTopRatedMoviesList(topMoviesResponse.results);
                            }
                            @Override
                            public void onError(Throwable e) {
                                //Log.d("On TV OnError", "ERROR!!");
                            }
                            @Override
                            public void onComplete() {
                                //Log.d("On TV Success", "Success!!");
                            }
                        }));
    }

    @Override
    public void fetchUpcomingMoviesList() {
        addDisposable(
                networkManager.apiUpcomingMovies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<UpcomingMoviesResponse>() {
                            @Override
                            public void onNext(UpcomingMoviesResponse upcomingMoviesResponse) {
                                view.updateUpcomingMoviesList(upcomingMoviesResponse.results);
                            }
                            @Override
                            public void onError(Throwable e) {
                                //Log.d("On TV OnError", "ERROR!!");
                            }
                            @Override
                            public void onComplete() {
                                //Log.d("On TV Success", "Success!!");
                            }
                        }));

    }

    @Override
    public void fetchNowPlayingMoviesList() {
        addDisposable(
                networkManager.apiNowPlayingMovies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<NowPlayingMoviesResponse>() {
                            @Override
                            public void onNext(NowPlayingMoviesResponse nowPlayingMoviesResponse) {
                                view.updateNowPlayingMoviesList(nowPlayingMoviesResponse.results);
                            }
                            @Override
                            public void onError(Throwable e) {
                                //Log.d("On TV OnError", "ERROR!!");
                            }
                            @Override
                            public void onComplete() {
                                //Log.d("On TV Success", "Success!!");
                            }
                        }));
    }



}
