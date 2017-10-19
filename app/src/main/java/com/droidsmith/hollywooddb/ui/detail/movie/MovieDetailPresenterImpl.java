package com.droidsmith.hollywooddb.ui.detail.movie;


import android.util.Log;

import com.droidsmith.hollywooddb.data.manager.DiskManager;
import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.people.CreditResponse;
import com.droidsmith.hollywooddb.ui.base.BasePresenter;
import com.droidsmith.hollywooddb.utility.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MovieDetailPresenterImpl extends BasePresenter<MovieDetailContract.MovieDetailView>
        implements MovieDetailContract.MovieDetailPresenter {

    private MovieDetails details;

    @Inject
    NetworkManager networkManager;

    @Inject
    DiskManager diskManager;

    @Inject
    SchedulerProvider schedulerProvider;

    public MovieDetailPresenterImpl(
            MovieDetailContract.MovieDetailView view, NetworkManager networkManager,
            DiskManager diskManager, SchedulerProvider schedulerProvider) {

        super(view);
        this.networkManager = networkManager;
        this.diskManager = diskManager;
        this.schedulerProvider = schedulerProvider;

    }


    @Override
    public void fetchBasicInfo(Integer movieID) {
        addDisposable(
                networkManager.apiMovieDetails(movieID)
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribeWith(new DisposableSingleObserver<MovieDetails>() {
                            @Override
                            public void onSuccess(MovieDetails movieDetails) {
                                details = movieDetails;
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
                networkManager.apiMovieCredits(movieID)
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
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

    @Override
    public void saveToFavorites() {
        diskManager.saveToRealm(details);
        view.onSuccessfulSave();
    }



}
