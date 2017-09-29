package com.droidsmith.hollywooddb.injection.module;


import android.app.Activity;

import com.droidsmith.hollywooddb.injection.component.MovieDetailActivityComponent;
import com.droidsmith.hollywooddb.injection.component.TVDetailActivityComponent;
import com.droidsmith.hollywooddb.ui.detail.movie.MovieDetailActivity;
import com.droidsmith.hollywooddb.ui.detail.tv.TVDetailActivity;
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

    @Binds
    @IntoMap
    @ActivityKey(MovieDetailActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMovieDetailActivity(MovieDetailActivityComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(TVDetailActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindTVDetailActivity(TVDetailActivityComponent.Builder builder);

}
