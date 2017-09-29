package com.droidsmith.hollywooddb.injection.module;


import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.manager.NetworkManagerImp;
import com.droidsmith.hollywooddb.data.remote.request.TMDBService;
import com.droidsmith.hollywooddb.ui.detail.tv.TVDetailActivity;
import com.droidsmith.hollywooddb.ui.detail.tv.TVDetailContract;
import com.droidsmith.hollywooddb.ui.detail.tv.TVDetailPresenterImp;

import dagger.Module;
import dagger.Provides;

@Module
public class TVDetailActivityModule {

    @Provides
    TVDetailContract.TVDetailView provideTVDetailView(TVDetailActivity tvDetailActivity){
        return tvDetailActivity;
    }

    @Provides
    NetworkManager provideNetworkManager(TMDBService tmdbService){
        return new NetworkManagerImp(tmdbService);
    }

    @Provides
    TVDetailContract.TVDetailPresenter provideTVDetailPresenter(TVDetailContract.TVDetailView tvDetailView, NetworkManager networkManager){
        return new TVDetailPresenterImp(tvDetailView,networkManager);
    }

}
