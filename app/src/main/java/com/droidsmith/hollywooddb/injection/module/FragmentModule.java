package com.droidsmith.hollywooddb.injection.module;

import android.support.v4.app.Fragment;

import com.droidsmith.hollywooddb.injection.component.FavoritesFragmentComponent;
import com.droidsmith.hollywooddb.injection.component.HomeFragmentComponent;
import com.droidsmith.hollywooddb.injection.component.MoviesFragmentComponent;
import com.droidsmith.hollywooddb.injection.component.TVFragmentComponent;
import com.droidsmith.hollywooddb.ui.main.fragments.favorites.FavoritesFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.movies.MoviesFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.tv.TVFragment;

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

    @Binds
    @IntoMap
    @FragmentKey(TVFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideTVFragmentFactory(TVFragmentComponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(FavoritesFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> provideFavoritesFragmentFactory(FavoritesFragmentComponent.Builder builder);


}
