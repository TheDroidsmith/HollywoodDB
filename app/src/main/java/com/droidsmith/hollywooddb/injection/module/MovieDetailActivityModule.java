package com.droidsmith.hollywooddb.injection.module;


import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.manager.NetworkManagerImp;
import com.droidsmith.hollywooddb.data.remote.request.TMDBService;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailActivity;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailContract;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailPresenterImpl;

import dagger.Module;
import dagger.Provides;

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
    MovieDetailContract.MovieDetailPresenter provideMovieDetailPresenter(MovieDetailContract.MovieDetailView movieDetailView, NetworkManager networkManager){
        return new MovieDetailPresenterImpl(movieDetailView,networkManager);
    }

}
