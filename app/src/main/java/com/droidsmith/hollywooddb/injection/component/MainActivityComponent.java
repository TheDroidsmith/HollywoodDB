package com.droidsmith.hollywooddb.injection.component;


import com.droidsmith.hollywooddb.injection.module.FragmentModule;
import com.droidsmith.hollywooddb.ui.main.MainActivity;
import com.droidsmith.hollywooddb.injection.module.MainActivityModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {MainActivityModule.class, FragmentModule.class})
public interface MainActivityComponent extends AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}

}
