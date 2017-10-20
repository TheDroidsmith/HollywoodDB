package com.droidsmith.hollywooddb.injection.module;


import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.manager.NetworkManagerImp;
import com.droidsmith.hollywooddb.data.remote.request.TMDBService;
import com.droidsmith.hollywooddb.ui.detail.tv.TVDetailActivity;
import com.droidsmith.hollywooddb.ui.detail.tv.TVDetailContract;
import com.droidsmith.hollywooddb.ui.detail.tv.TVDetailPresenterImp;
import com.droidsmith.hollywooddb.utility.rx.AppSchedulerProvider;

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
    AppSchedulerProvider provideAppSchedulerProvider(){
        return new AppSchedulerProvider();
    }

    @Provides
    TVDetailContract.TVDetailPresenter provideTVDetailPresenter(
            TVDetailContract.TVDetailView tvDetailView,
            NetworkManager networkManager,
            AppSchedulerProvider appSchedulerProvider){

        return new TVDetailPresenterImp(tvDetailView, networkManager, appSchedulerProvider);

    }

}
