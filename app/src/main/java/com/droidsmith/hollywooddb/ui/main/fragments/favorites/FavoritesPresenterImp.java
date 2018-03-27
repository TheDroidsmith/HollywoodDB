package com.droidsmith.hollywooddb.ui.main.fragments.favorites;


import com.droidsmith.hollywooddb.data.manager.DiskManager;
import com.droidsmith.hollywooddb.data.local.Favorite;
import com.droidsmith.hollywooddb.ui.base.BasePresenter;

import javax.inject.Inject;


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
    public void fetchFavoritesList() {

    }
}
