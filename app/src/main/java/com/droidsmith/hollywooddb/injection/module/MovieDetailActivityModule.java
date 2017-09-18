package com.droidsmith.hollywooddb.injection.module;


import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailActivity;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailContract;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieDetailActivityModule {

    @Provides
    MovieDetailContract.MovieDetailView provideMainView(MovieDetailActivity movieDetailActivity){
        return movieDetailActivity;
    }

    @Provides
    MovieDetailContract.MovieDetailPresenter provideMovieDetailPresenter(MovieDetailContract.MovieDetailView movieDetailView){
        return new MovieDetailPresenterImpl(movieDetailView);
    }

}
