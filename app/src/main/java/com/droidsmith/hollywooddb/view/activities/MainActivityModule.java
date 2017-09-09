package com.droidsmith.hollywooddb.view.activities;


import com.droidsmith.hollywooddb.presenter.MainPresenter;
import com.droidsmith.hollywooddb.presenter.MainPresenterImp;
import com.droidsmith.hollywooddb.view.activities.views.MainView;

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