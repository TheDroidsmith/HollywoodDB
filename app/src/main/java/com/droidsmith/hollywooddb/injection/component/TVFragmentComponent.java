package com.droidsmith.hollywooddb.injection.component;

import com.droidsmith.hollywooddb.injection.module.TVFragmentModule;
import com.droidsmith.hollywooddb.ui.main.fragments.tv.TVFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = TVFragmentModule.class)
public interface TVFragmentComponent extends AndroidInjector<TVFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TVFragment>{}
}
