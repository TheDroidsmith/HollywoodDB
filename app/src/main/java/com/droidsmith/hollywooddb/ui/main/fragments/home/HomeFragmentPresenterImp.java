package com.droidsmith.hollywooddb.ui.main.fragments.home;


import android.util.Log;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShow;
import com.droidsmith.hollywooddb.ui.base.BasePresenter;
import com.droidsmith.hollywooddb.utility.rx.SchedulerProvider;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class HomeFragmentPresenterImp extends BasePresenter<HomeContract.HomeView> implements HomeContract.HomePresenter {


    @Inject
    public NetworkManager networkManager;

    @Inject
    SchedulerProvider schedulerProvider;

    @Inject
    public HomeFragmentPresenterImp(HomeContract.HomeView view,
                                    NetworkManager networkManager,
                                    SchedulerProvider schedulerProvider) {
        super(view);
        this.networkManager = networkManager;
        this.schedulerProvider = schedulerProvider;
    }


    @Override
    public void fetchPopularMoviesList() {
        addDisposable(
                networkManager.apiPopularMovies()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeWith(new DisposableSingleObserver<PopularMoviesResponse>() {
                    @Override
                    public void onSuccess(PopularMoviesResponse popularMoviesResponse) {
                        view.updatePopularMovieList(popularMoviesResponse.results);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }));

    }

    @Override
    public void fetchPopularTVList() {
        addDisposable(
                networkManager.apiPopularTV()
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribeWith(new DisposableSingleObserver<PopularTVResponse>() {
                            @Override
                            public void onSuccess(PopularTVResponse popularTVResponse) {
                                view.updatePopularTVList(popularTVResponse.results);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        }));
    }

    @Override
    public void fetchTopTVList() {
        //networkManager.callTopTV();
    }
}
