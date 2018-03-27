package com.droidsmith.hollywooddb.data.manager;


import com.droidsmith.hollywooddb.data.local.Favorite;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;

import io.reactivex.Flowable;

public interface DiskManager {

    Flowable<Favorite> getAllFavorites();
}
