package com.droidsmith.hollywooddb;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.droidsmith.hollywooddb.view.adapters.MainPagerAdapter;
import com.droidsmith.hollywooddb.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

//TODO: Fix the page swipe issue

public class MainActivity extends AppCompatActivity implements MainView{


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
    //MainView methods
    ////////////////

    @Override
    public void setupBottomNavigationView(){

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottom_action_home:
                                mainViewpager.setCurrentItem(0);
                                return true;
                            case R.id.bottom_action_movies:
                                mainViewpager.setCurrentItem(1);
                                return true;
                            case R.id.bottom_action_tv:
                                mainViewpager.setCurrentItem(2);
                                return true;
                            case R.id.bottom_action_favorites:
                                mainViewpager.setCurrentItem(3);
                                return true;
                            case R.id.bottom_action_history:
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.main_action_search:
                return true;
            case R.id.dummy_item0:
                return true;
            case R.id.dummy_item1:
                return true;



        }

        return super.onOptionsItemSelected(item);
    }

}
