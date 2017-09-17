package com.droidsmith.hollywooddb.injection.component;

import com.droidsmith.hollywooddb.injection.module.MoviesFragmentModule;
import com.droidsmith.hollywooddb.ui.main.fragments.movies.MoviesFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

//Sub-component for parent activity module(MainActivityModule)
@Subcomponent(modules = MoviesFragmentModule.class)
public interface MoviesFragmentComponent extends AndroidInjector<MoviesFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MoviesFragment> {}
}
