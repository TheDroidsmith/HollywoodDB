package com.droidsmith.hollywooddb.ui.detail.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.droidsmith.hollywooddb.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

public class MovieDetailActivity extends AppCompatActivity implements MovieDetailContract.MovieDetailView{

    Unbinder unbinder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(this);






        setContentView(R.layout.activity_movie_detail);
    }
}
