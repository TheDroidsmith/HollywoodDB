package com.droidsmith.hollywooddb.injection.module;

import android.app.Application;
import android.content.Context;

import com.droidsmith.hollywooddb.injection.component.MainActivityComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//The AppModule needs the sub-components of everything that needs the application context.
@Module(subcomponents = {MainActivityComponent.class})
public class AppModule {

    //I think we also provide retrofit, okhttp, sharedPref, etc. here too

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

}
