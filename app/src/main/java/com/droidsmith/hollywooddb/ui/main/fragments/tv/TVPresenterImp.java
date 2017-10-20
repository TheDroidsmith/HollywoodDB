package com.droidsmith.hollywooddb.ui.main.fragments.tv;


import android.util.Log;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.AiringTodayResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.OnTheAirResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShow;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TopTVResponse;
import com.droidsmith.hollywooddb.ui.base.BasePresenter;
import com.droidsmith.hollywooddb.utility.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class TVPresenterImp extends BasePresenter<TVContract.TVView> implements TVContract.TVPresenter {

    @Inject
    public NetworkManager networkManager;

    @Inject
    SchedulerProvider schedulerProvider;


    public TVPresenterImp(TVContract.TVView view, NetworkManager networkManager, SchedulerProvider schedulerProvider) {
        super(view);
        this.networkManager = networkManager;
        this.schedulerProvider = schedulerProvider;
    }


    @Override
    public void fetchAiringTodayList() {
        addDisposable(
                networkManager.apiAiringTodayTV()
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribeWith(new DisposableSingleObserver<AiringTodayResponse>() {
                            @Override
                            public void onSuccess(AiringTodayResponse airingTodayResponse) {
                                view.updateAiringTodayList(airingTodayResponse.results);
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
    public void fetchOnTheAirList() {
        addDisposable(
                networkManager.apiOnTheAirTV()
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribeWith(new DisposableSingleObserver<OnTheAirResponse>() {
                            @Override
                            public void onSuccess(OnTheAirResponse onTheAirResponse) {
                                view.updateOnTheAirList(onTheAirResponse.results);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        }));
    }

    @Override
    public void fetchTopRatedList() {
        addDisposable(
                networkManager.apiTopTV()
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribeWith(new DisposableSingleObserver<TopTVResponse>() {
                            @Override
                            public void onSuccess(TopTVResponse topTVResponse) {
                                view.updateTopRatedList(topTVResponse.results);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        }));
    }
}
