package com.droidsmith.hollywooddb.injection.component;


import com.droidsmith.hollywooddb.injection.module.MovieDetailActivityModule;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {MovieDetailActivityModule.class})
public interface MovieDetailActivityComponent extends AndroidInjector<MovieDetailActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MovieDetailActivity>{}
}
