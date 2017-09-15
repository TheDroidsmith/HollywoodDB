package com.droidsmith.hollywooddb.ui.main.fragments.movies;


import android.util.Log;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.LatestMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResponse;
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
        //make a facade class so this can be tested for schedulers.
        //But, don't forget to check trampoline.
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
                                Log.d("Latest Movie OnError", "!!!!!!!!!ERROR!!!!!!!!!!");
                            }

                            @Override
                            public void onComplete() {
                                Log.d("Latest Movie Success", "!!!!!!!!!YAYYYYYY!!!!!!!!!!");
                            }
                        }));

    }

    @Override
    public void fetchHighestRatedMoviesList() {

    }

    @Override
    public void fetchUpcomingMoviesList() {
        //make a facade class so this can be tested for schedulers.
        //But, don't forget to check trampoline.
        addDisposable(
                networkManager.apiUpcomingMovies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<UpcomingMoviesResponse>() {
                            @Override
                            public void onNext(UpcomingMoviesResponse upcomingMoviesResponse) {
                                view.updateUpcomingMoviesList(upcomingMoviesResponse.results);
                                for (Movie movie : upcomingMoviesResponse.results) {
                                    Log.d("Latest Movies ---->", "Movie ---- " + movie.title);
                                }
                            }
                            @Override
                            public void onError(Throwable e) {
                                Log.d("Latest Movie OnError", "!!!!!!!!!ERROR!!!!!!!!!!");
                            }

                            @Override
                            public void onComplete() {
                                Log.d("Latest Movie Success", "!!!!!!!!!YAYYYYYY!!!!!!!!!!");
                            }
                        }));

    }

    @Override
    public void fetchClassicMoviesList() {

    }


}
