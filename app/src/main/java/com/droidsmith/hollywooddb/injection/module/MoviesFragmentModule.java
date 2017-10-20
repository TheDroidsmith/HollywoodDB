package com.droidsmith.hollywooddb.injection.module;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.manager.NetworkManagerImp;
import com.droidsmith.hollywooddb.data.remote.request.TMDBService;
import com.droidsmith.hollywooddb.ui.main.fragments.movies.MoviesContract;
import com.droidsmith.hollywooddb.ui.main.fragments.movies.MoviesFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.movies.MoviesPresenterImp;
import com.droidsmith.hollywooddb.utility.rx.AppSchedulerProvider;

import dagger.Module;
import dagger.Provides;

//Module for sub-component MoviesFragmentComponent
@Module
public class MoviesFragmentModule {

    @Provides
    MoviesContract.MoviesView provideMoviesFragmentView(MoviesFragment moviesFragment){
        return moviesFragment;
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
    MoviesContract.MoviesPresenter provideMoviesFragmentPresenter(MoviesContract.MoviesView moviesView,
                                                                  NetworkManager networkManager,
                                                                  AppSchedulerProvider appSchedulerProvider){

        return new MoviesPresenterImp(moviesView, networkManager, appSchedulerProvider);
    }

}
