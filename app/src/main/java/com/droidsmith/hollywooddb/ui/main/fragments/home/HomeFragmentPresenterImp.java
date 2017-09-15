package com.droidsmith.hollywooddb.ui.main.fragments.home;


import android.util.Log;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShow;
import com.droidsmith.hollywooddb.ui.base.BasePresenter;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class HomeFragmentPresenterImp extends BasePresenter<HomeContract.HomeView> implements HomeContract.HomePresenter {


    @Inject
    public NetworkManager networkManager;

    @Inject
    public HomeFragmentPresenterImp(HomeContract.HomeView view, NetworkManager networkManager) {
        super(view);
        this.networkManager = networkManager;
    }



    @Override
    public void fetchPopularMoviesList() {
        //make a facade class so this can be tested for schedulers.
        //But, don't forget to check trampoline.
        addDisposable(
                networkManager.apiPopularMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<PopularMoviesResponse>() {
                    @Override
                    public void onNext(PopularMoviesResponse PopularMoviesResponse) {
                        view.updatePopularMovieList(PopularMoviesResponse.results);
                        for (Movie movie : PopularMoviesResponse.results) {
                            Log.d("Popular Movies ---->", "Movie ---- " + movie.title);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.d("Pop Movie OnError", "!!!!!!!!!ERROR!!!!!!!!!!");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("Pop Movie Success", "!!!!!!!!!YAYYYYYY!!!!!!!!!!");
                    }
                }));

    }

    @Override
    public void fetchPopularTVList() {
        //make a facade class so this can be tested for schedulers.
        //But, don't forget to check trampoline.
        addDisposable(
                networkManager.apiPopularTV()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<PopularTVResponse>() {
                            @Override
                            public void onNext(PopularTVResponse popularTVResponse) {
                                view.updatePopularTVList(popularTVResponse.results);
                                for (TVShow show : popularTVResponse.results) {
                                    Log.d("Popular Show ---->", "Show ---- " + show.name);
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("Pop TV OnError", "!!!!!!!!!ERROR!!!!!!!!!!");
                            }

                            @Override
                            public void onComplete() {
                                Log.d("PopTV Success", "!!!!!!!!!YAYYYYYY!!!!!!!!!!");
                            }
                        }));
    }

    @Override
    public void fetchTopTVList() {
        //networkManager.callTopTV();
    }
}
