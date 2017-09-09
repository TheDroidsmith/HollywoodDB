package com.droidsmith.hollywooddb.injection.module;


import com.droidsmith.hollywooddb.ui.home.MainPresenter;
import com.droidsmith.hollywooddb.ui.home.MainPresenterImp;
import com.droidsmith.hollywooddb.ui.home.MainActivity;
import com.droidsmith.hollywooddb.ui.home.MainView;

import dagger.Module;
import dagger.Provides;

@Module
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