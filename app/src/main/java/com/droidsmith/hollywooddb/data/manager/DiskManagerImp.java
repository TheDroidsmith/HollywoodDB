package com.droidsmith.hollywooddb.data.manager;


import android.util.Log;

import com.droidsmith.hollywooddb.data.model.Favorite;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;

import javax.inject.Inject;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class DiskManagerImp implements DiskManager {

    @Inject
    Realm realm;

    @Inject
    public DiskManagerImp(Realm realm) {
        this.realm = realm;
    }


    @Override
    public RealmResults<Favorite> getAllFavorites() {
        RealmResults<Favorite> results;
        try{
            results = realm.where(Favorite.class).findAllSortedAsync("name");
        } finally {

        }
        //TODO: just use observable for this
        return results;


    }

    @Override
    public void saveToRealm(MovieDetails details) {
        realm.executeTransactionAsync(realm -> {
                Favorite fav = realm.createObject(Favorite.class);
                fav.setId(details.id);
                fav.setName(details.title);
                fav.setPosterPath(details.posterPath);
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    realm.close();
                }
            }, new Realm.Transaction.OnError() {
                @Override
                public void onError(Throwable error) {
                    // Transaction failed and was automatically canceled.
                    Log.d("DiskManager","Failed saving favorite");
                }
        });

    }


    @Override
    public void closeRealm() {
        //TODO: may need to change this for async calls
        realm.close();
    }
}
