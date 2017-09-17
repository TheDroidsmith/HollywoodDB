package com.droidsmith.hollywooddb.injection.module;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.manager.NetworkManagerImp;
import com.droidsmith.hollywooddb.data.remote.request.TMDBInterface;
import com.droidsmith.hollywooddb.ui.main.fragments.tv.TVContract;
import com.droidsmith.hollywooddb.ui.main.fragments.tv.TVFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.tv.TVPresenterImp;

import dagger.Module;
import dagger.Provides;

@Module
public class TVFragmentModule {

    @Provides
    TVContract.TVView provideMoviesFragmentView(TVFragment tvFragment){
        return tvFragment;
    }

    @Provides
    NetworkManager provideNetworkManager(TMDBInterface tmdbInterface){
        return new NetworkManagerImp(tmdbInterface);
    }

    @Provides
    TVContract.TVPresenter provideMoviesFragmentPresenter(TVContract.TVView tvView, NetworkManager networkManager){
        return new TVPresenterImp(tvView,networkManager);
    }

}
