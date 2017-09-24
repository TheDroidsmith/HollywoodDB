package com.droidsmith.hollywooddb.ui.detail.movie;


import android.util.Log;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.LatestMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.people.CreditResponse;
import com.droidsmith.hollywooddb.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MovieDetailPresenterImpl extends BasePresenter<MovieDetailContract.MovieDetailView>
        implements MovieDetailContract.MovieDetailPresenter {

    @Inject
    public NetworkManager networkManager;

    @Inject
    public MovieDetailPresenterImpl(MovieDetailContract.MovieDetailView view, NetworkManager networkManager) {
        super(view);
        this.networkManager = networkManager;

    }


    @Override
    public void fetchBasicInfo(Integer movieID) {
        addDisposable(
                networkManager.apiMovieDetails(movieID)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<MovieDetails>() {
                            @Override
                            public void onSuccess(MovieDetails movieDetails) {
                                view.setBasicInfo(movieDetails);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("Error Details","On Error Thrown");
                            }
                        }));
    }

    @Override
    public void fetchCast(Integer movieID) {
        addDisposable(
                networkManager.apiCredits(movieID)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<CreditResponse>() {
                            @Override
                            public void onSuccess(CreditResponse creditResponse) {
                                view.setCastList(creditResponse.cast);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("Error Cast","On Error Thrown");
                            }
                        }));
    }


}
