package com.droidsmith.hollywooddb.ui.detail.tv;


import android.util.Log;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.people.CreditResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShowDetails;
import com.droidsmith.hollywooddb.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class TVDetailPresenterImp extends BasePresenter<TVDetailContract.TVDetailView>
        implements TVDetailContract.TVDetailPresenter{


    @Inject
    public NetworkManager networkManager;


    public TVDetailPresenterImp(TVDetailContract.TVDetailView view,
                                   NetworkManager networkManager) {
        super(view);
        this.networkManager = networkManager;
    }

    @Override
    public void fetchBasicInfo(Integer tvID) {
        networkManager.apiTVShowDetails(tvID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<TVShowDetails>() {
                    @Override
                    public void onSuccess(TVShowDetails tvDetails) {
                        view.setBasicInfo(tvDetails);
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.d("On Error", "ERROR getting tv details");
                    }
                });

    }

    @Override
    public void fetchCast(Integer tvID) {

        addDisposable(
                networkManager.apiTVCredits(tvID)
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
