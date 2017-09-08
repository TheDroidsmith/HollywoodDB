package com.droidsmith.hollywooddb;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;

import com.droidsmith.hollywooddb.view.adapters.MainPagerAdapter;
import com.droidsmith.hollywooddb.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

//TODO: Fix the page swipe issue

public class MainActivity extends FragmentActivity implements MainView{


    @BindView(R.id.main_viewpager)
    ViewPager mainViewpager;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    private MenuItem prevMenuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        PagerAdapter pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mainViewpager.setAdapter(pagerAdapter);

        setupBottomNavigationView();
        setupViewPager();


    }


    ////////////////
    //MainView
    ////////////////

    @Override
    public void setupBottomNavigationView(){

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                mainViewpager.setCurrentItem(0);
                                return true;
                            case R.id.action_movies:
                                mainViewpager.setCurrentItem(1);
                                return true;
                            case R.id.action_tv:
                                mainViewpager.setCurrentItem(2);
                                return true;
                            case R.id.action_favorites:
                                mainViewpager.setCurrentItem(3);
                                return true;
                            case R.id.action_history:
                                mainViewpager.setCurrentItem(4);
                                return true;
                        }
                        return false;
                    }
                });

    }

    @Override
    public void setupViewPager(){

        final ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);

                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

        mainViewpager.addOnPageChangeListener(pageChangeListener);

        mainViewpager.post(new Runnable(){
            @Override
            public void run() {
                pageChangeListener.onPageSelected(mainViewpager.getCurrentItem());
            }
        });

    }

}
