package com.droidsmith.hollywooddb.injection.module;


import com.droidsmith.hollywooddb.data.manager.DiskManager;
import com.droidsmith.hollywooddb.data.manager.DiskManagerImp;
import com.droidsmith.hollywooddb.ui.main.fragments.favorites.FavoritesContract;
import com.droidsmith.hollywooddb.ui.main.fragments.favorites.FavoritesFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.favorites.FavoritesPresenterImp;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class FavoritesFragmentModule {

    @Provides
    FavoritesContract.FavoritesView provideFavoritesFragmentView(FavoritesFragment favoritesFragment){
        return favoritesFragment;
    }

    @Provides
    DiskManager provideDiskManager(Realm realm){
        return new DiskManagerImp(realm);
    }

    @Provides
    FavoritesContract.FavoritesPresenter provideFavoritesFragmentPresenter(
            FavoritesContract.FavoritesView favoritesView,
            DiskManager diskManager){

        return new FavoritesPresenterImp(favoritesView, diskManager);
    }

}
