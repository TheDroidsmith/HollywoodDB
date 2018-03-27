package com.droidsmith.hollywooddb.data.manager;


import android.support.annotation.NonNull;
import android.util.Log;

import com.droidsmith.hollywooddb.data.local.Favorite;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;


import io.reactivex.Flowable;


public class DiskManagerImp implements DiskManager {


    @Override
    public Flowable<Favorite> getAllFavorites() {
        return null;
    }
}
