package com.droidsmith.hollywooddb.injection.component;


import com.droidsmith.hollywooddb.injection.module.TVDetailActivityModule;
import com.droidsmith.hollywooddb.ui.detail.tv.TVDetailActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {TVDetailActivityModule.class})
public interface TVDetailActivityComponent extends AndroidInjector<TVDetailActivity>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TVDetailActivity>{}
}
