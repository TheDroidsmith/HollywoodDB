package com.droidsmith.hollywooddb.injection.module;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.remote.request.TMDBInterface;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeFragmentPresenter;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeFragmentPresenterImp;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeFragmentView;

import dagger.Module;
import dagger.Provides;

//Module for sub-component HomeFragmentComponent
@Module
public class HomeFragmentModule {

    @Provides
    HomeFragmentView provideHomeFragmentView(HomeFragment homeFragment){
        return homeFragment;
    }

    @Provides
    HomeFragmentPresenter provideHomeFragmentPresenter(HomeFragmentView homeFragmentView, NetworkManager networkManager){
        return new HomeFragmentPresenterImp(homeFragmentView,networkManager);
    }

}
