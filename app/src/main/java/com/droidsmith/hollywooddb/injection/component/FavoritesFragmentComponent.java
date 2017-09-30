package com.droidsmith.hollywooddb.injection.component;


import com.droidsmith.hollywooddb.injection.module.FavoritesFragmentModule;
import com.droidsmith.hollywooddb.ui.main.fragments.favorites.FavoritesFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

//Sub-component for parent activity module(MainActivityModule)
@Subcomponent(modules = FavoritesFragmentModule.class)
public interface FavoritesFragmentComponent extends AndroidInjector<FavoritesFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<FavoritesFragment> {
    }
}
