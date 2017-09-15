package com.droidsmith.hollywooddb.injection.module;

import android.support.v4.app.Fragment;

import com.droidsmith.hollywooddb.injection.component.HomeFragmentComponent;
import com.droidsmith.hollywooddb.injection.component.MoviesFragmentComponent;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.movies.MoviesFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

//module for AppComponent
@Module
public abstract class FragmentModule {
    //Do this for all fragments in main
    @Binds
    @IntoMap
    @FragmentKey(HomeFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideHomeFragmentFactory(HomeFragmentComponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(MoviesFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideMoviesFragmentFactory(MoviesFragmentComponent.Builder builder);
}
