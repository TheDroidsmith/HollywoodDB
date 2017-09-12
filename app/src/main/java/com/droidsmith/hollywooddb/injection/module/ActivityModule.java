package com.droidsmith.hollywooddb.injection.module;


import android.app.Activity;

import com.droidsmith.hollywooddb.ui.main.MainActivity;
import com.droidsmith.hollywooddb.injection.component.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;



@Module
public abstract class ActivityModule {

    //Do this for every activity.
    //Every activity should have a component with a sub-component annotation.
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(MainActivityComponent.Builder builder);

}
