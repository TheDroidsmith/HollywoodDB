package com.droidsmith.hollywooddb.injection.module;

import android.app.Application;
import android.content.Context;

import com.droidsmith.hollywooddb.injection.component.MainActivityComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//Make sure other activities are sub-components here
@Module(subcomponents = {MainActivityComponent.class})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

}
