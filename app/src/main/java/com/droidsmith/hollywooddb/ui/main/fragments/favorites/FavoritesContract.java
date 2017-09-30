package com.droidsmith.hollywooddb.ui.main.fragments.favorites;


import com.droidsmith.hollywooddb.data.model.Favorite;

import io.realm.OrderedRealmCollection;
import io.realm.RealmResults;

public interface FavoritesContract {

    interface FavoritesView{
        void updateFavorites(RealmResults<Favorite> results);
    }

    interface FavoritesPresenter{

        void closeRealm();

        void fetchFavoritesList();

    }

}
