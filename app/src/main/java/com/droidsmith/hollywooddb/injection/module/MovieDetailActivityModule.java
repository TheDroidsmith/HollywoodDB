package com.droidsmith.hollywooddb.injection.module;


import com.droidsmith.hollywooddb.data.manager.DiskManager;
import com.droidsmith.hollywooddb.data.manager.DiskManagerImp;
import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.manager.NetworkManagerImp;
import com.droidsmith.hollywooddb.data.remote.request.TMDBService;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailActivity;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailContract;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailPresenterImpl;
import com.droidsmith.hollywooddb.utility.rx.AppSchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class MovieDetailActivityModule {

    @Provides
    MovieDetailContract.MovieDetailView provideMovieDetailView(MovieDetailActivity movieDetailActivity){
        return movieDetailActivity;
    }

    @Provides
    NetworkManager provideNetworkManager(TMDBService tmdbService){
        return new NetworkManagerImp(tmdbService);
    }

    @Provides
    DiskManager provideDiskManager(Realm realm){
        return new DiskManagerImp(realm);
    }

    @Provides
    AppSchedulerProvider provideAppSchedulerProvider(){
        return new AppSchedulerProvider();
    }

    @Provides
    MovieDetailContract.MovieDetailPresenter provideMovieDetailPresenter(
            MovieDetailContract.MovieDetailView movieDetailView,
            NetworkManager networkManager,
            DiskManager diskManager,
            AppSchedulerProvider appSchedulerProvider){

        return new MovieDetailPresenterImpl(movieDetailView, networkManager, diskManager, appSchedulerProvider);
    }

}
