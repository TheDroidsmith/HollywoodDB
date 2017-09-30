package com.droidsmith.hollywooddb.data.manager;


import com.droidsmith.hollywooddb.data.model.Favorite;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;

import io.realm.OrderedRealmCollection;
import io.realm.RealmResults;

public interface DiskManager {

    void closeRealm();

    RealmResults<Favorite> getAllFavorites();

    void saveToRealm(MovieDetails details);

}
