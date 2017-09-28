package com.droidsmith.hollywooddb.ui.main.fragments.tv;


import android.util.Log;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.AiringTodayResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.OnTheAirResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShow;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TopTVResponse;
import com.droidsmith.hollywooddb.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class TVPresenterImp extends BasePresenter<TVContract.TVView> implements TVContract.TVPresenter {




    @Inject
    public NetworkManager networkManager;

    @Inject
    public TVPresenterImp(TVContract.TVView view, NetworkManager networkManager) {
        super(view);
        this.networkManager = networkManager;
    }


    @Override
    public void fetchAiringTodayList() {
        addDisposable(
                networkManager.apiAiringTodayTV()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<AiringTodayResponse>() {
                            @Override
                            public void onNext(AiringTodayResponse airingTodayResponse) {
                                view.updateAiringTodayList(airingTodayResponse.results);
                            }
                            @Override
                            public void onError(Throwable e) {
                                //Log.d("Latest Movie OnError", "Error");
                            }
                            @Override
                            public void onComplete() {
                                //Log.d("Latest Movie Success", "Success!!!!");
                            }
                        }));
    }

    @Override
    public void fetchPopularTVList() {
        addDisposable(
                networkManager.apiPopularTV()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<PopularTVResponse>() {
                            @Override
                            public void onNext(PopularTVResponse popularTVResponse) {
                                view.updatePopularTVList(popularTVResponse.results);
                            }
                            @Override
                            public void onError(Throwable e) {
                                //Log.d("Popular TV OnError", "ERROR!!");
                            }
                            @Override
                            public void onComplete() {
                                //Log.d("Popular TV Success", "Success!!");
                            }
                        }));
    }

    @Override
    public void fetchOnTheAirList() {
        addDisposable(
                networkManager.apiOnTheAirTV()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<OnTheAirResponse>() {
                            @Override
                            public void onNext(OnTheAirResponse onTheAirResponse) {
                                view.updateOnTheAirList(onTheAirResponse.results);
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
    public void fetchTopRatedList() {
        addDisposable(
                networkManager.apiTopTV()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<TopTVResponse>() {
                            @Override
                            public void onNext(TopTVResponse topTVResponse) {
                                view.updateTopRatedList(topTVResponse.results);
                                for (TVShow show: topTVResponse.results) {
                                    Log.d("Top TV -->", "Show -- " + show.name);
                                }
                            }
                            @Override
                            public void onError(Throwable e) {
                                //Log.d("Top TV OnError", "ERROR!!");
                            }
                            @Override
                            public void onComplete() {
                                //Log.d("Top TV Success", "Success!!");
                            }
                        }));
    }
}
