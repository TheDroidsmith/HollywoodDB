package com.droidsmith.hollywooddb.data.manager;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResponse;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TopTVResponse;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface NetworkManager {

    Observable<PopularMoviesResponse> apiPopularMovies();

    Observable<PopularTVResponse> apiPopularTV();

    Observable<TopTVResponse> apiTopTV();

}
