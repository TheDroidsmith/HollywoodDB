package com.droidsmith.hollywooddb.injection.module;

import com.droidsmith.hollywooddb.data.manager.NetworkManager;
import com.droidsmith.hollywooddb.data.manager.NetworkManagerImp;
import com.droidsmith.hollywooddb.data.remote.request.TMDBService;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeContract;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeFragmentPresenterImp;

import dagger.Module;
import dagger.Provides;

//Module for sub-component HomeFragmentComponent
@Module
public class HomeFragmentModule {

    @Provides
    HomeContract.HomeView provideHomeFragmentView(HomeFragment homeFragment){
        return homeFragment;
    }

    @Provides
    NetworkManager provideNetworkManager(TMDBService tmdbService){
        return new NetworkManagerImp(tmdbService);
    }

    @Provides
    HomeContract.HomePresenter provideHomeFragmentPresenter(HomeContract.HomeView homeView, NetworkManager networkManager){
        return new HomeFragmentPresenterImp(homeView,networkManager);
    }

}
