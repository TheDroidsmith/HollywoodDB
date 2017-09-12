package com.droidsmith.hollywooddb.injection.module;


import com.droidsmith.hollywooddb.injection.component.HomeFragmentComponent;
import com.droidsmith.hollywooddb.ui.main.MainPresenter;
import com.droidsmith.hollywooddb.ui.main.MainPresenterImp;
import com.droidsmith.hollywooddb.ui.main.MainActivity;
import com.droidsmith.hollywooddb.ui.main.MainView;

import dagger.Module;
import dagger.Provides;

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