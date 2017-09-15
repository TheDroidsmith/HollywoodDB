package com.droidsmith.hollywooddb.injection.component;

import com.droidsmith.hollywooddb.injection.module.HomeFragmentModule;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

//Sub-component for parent activity module(MainActivityModule)
@Subcomponent(modules = HomeFragmentModule.class)
public interface HomeFragmentComponent extends AndroidInjector<HomeFragment>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HomeFragment> {
    }
}
