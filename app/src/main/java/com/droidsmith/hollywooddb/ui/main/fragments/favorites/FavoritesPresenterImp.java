package com.droidsmith.hollywooddb.ui.main.fragments.favorites;


import com.droidsmith.hollywooddb.data.manager.DiskManager;
import com.droidsmith.hollywooddb.data.model.Favorite;
import com.droidsmith.hollywooddb.ui.base.BasePresenter;

import javax.inject.Inject;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmResults;

public class FavoritesPresenterImp extends BasePresenter<FavoritesContract.FavoritesView>
        implements FavoritesContract.FavoritesPresenter{

    @Inject
    DiskManager diskManager;

    @Inject
    public FavoritesPresenterImp(FavoritesContract.FavoritesView view,
                                 DiskManager diskManager) {
        super(view);
        this.diskManager = diskManager;
    }


    @Override
    public void closeRealm() {
        diskManager.closeRealm();
    }

    @Override
    public void fetchFavoritesList() {
        RealmResults<Favorite> results = diskManager.getAllFavorites();
        if(!results.isEmpty()){
            view.updateFavorites(results);
        }
    }
}
