package com.droidsmith.hollywooddb.ui.main.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.droidsmith.hollywooddb.ui.main.fragments.favorites.FavoritesFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.history.HistoryFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.home.HomeFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.movies.MoviesFragment;
import com.droidsmith.hollywooddb.ui.main.fragments.tv.TVFragment;


public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 5;


    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new MoviesFragment();
            case 2:
                return new TVFragment();
            case 3:
                return new FavoritesFragment();
            case 4:
                return new HistoryFragment();
            default:
                return new HomeFragment();
        }

    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
