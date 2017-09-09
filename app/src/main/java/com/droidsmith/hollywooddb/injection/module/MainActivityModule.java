package com.droidsmith.hollywooddb.injection.module;


import com.droidsmith.hollywooddb.data.remote.request.TMDBInterface;
import com.droidsmith.hollywooddb.injection.component.HomeFragmentComponent;
import com.droidsmith.hollywooddb.ui.home.MainPresenter;
import com.droidsmith.hollywooddb.ui.home.MainPresenterImp;
import com.droidsmith.hollywooddb.ui.home.MainActivity;
import com.droidsmith.hollywooddb.ui.home.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = HomeFragmentComponent.class)
public class MainActivityModule {

    @Provides
    MainView provideMainView(MainActivity mainActivity){
        return mainActivity;
    }

    @Provides
    MainPresenter provideMainPresenter(MainView mainView){
        return new MainPresenterImp(mainView);
    }

}