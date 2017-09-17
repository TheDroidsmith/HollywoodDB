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
    public void fetchTopRatedMoviesList() {
        //make a facade class so this can be tested for schedulers.
        //But, don't forget to check trampoline.
        addDisposable(
                networkManager.apiTopMovies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<TopMoviesResponse>() {
                            @Override
                            public void onNext(TopMoviesResponse topMoviesResponse) {
                                view.updateTopRatedMoviesList(topMoviesResponse.results);
                                for (Movie movie : topMoviesResponse.results) {
                                    Log.d("Top Movies ---->", "Movie ---- " + movie.title);
                                }
                            }
                            @Override
                            public void onError(Throwable e) {
                                Log.d("Top Movie OnError", "!!!!!!!!!ERROR!!!!!!!!!!");
                            }
                            @Override
                            public void onComplete() {
                                Log.d("Top Movie Success", "!!!!!!!!!YAYYYYYY!!!!!!!!!!");
                            }
                        }));
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
                                    Log.d("Upcoming Movies ---->", "Movie ---- " + movie.title);
                                }
                            }
                            @Override
                            public void onError(Throwable e) {
                                Log.d("Upcoming OnError", "!!!!!!!!!ERROR!!!!!!!!!!");
                            }
                            @Override
                            public void onComplete() {
                                Log.d("Upcoming Success", "!!!!!!!!!YAYYYYYY!!!!!!!!!!");
                            }
                        }));

    }

    @Override
    public void fetchNowPlayingMoviesList() {
        //make a facade class so this can be tested for schedulers.
        //But, don't forget to check trampoline.
        addDisposable(
                networkManager.apiNowPlayingMovies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<NowPlayingMoviesResponse>() {
                            @Override
                            public void onNext(NowPlayingMoviesResponse nowPlayingMoviesResponse) {
                                view.updateNowPlayingMoviesList(nowPlayingMoviesResponse.results);
                                for (Movie movie : nowPlayingMoviesResponse.results) {
                                    Log.d("NowPlaying Movies ---->", "Movie ---- " + movie.title);
                                }
                            }
                            @Override
                            public void onError(Throwable e) {
                                Log.d("Now Playing OnError", "!!!!!!!!!ERROR!!!!!!!!!!");
                            }
                            @Override
                            public void onComplete() {
                                Log.d("Now Playing Success", "!!!!!!!!!YAYYYYYY!!!!!!!!!!");
                            }
                        }));
    }



}
