package com.droidsmith.hollywooddb.ui.main.fragments.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResults;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResults;
import com.droidsmith.hollywooddb.ui.main.fragments.home.adapters.PopularMoviesListAdapter;
import com.droidsmith.hollywooddb.ui.main.fragments.home.adapters.PopularTVListAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;


public class HomeFragment extends Fragment implements HomeFragmentView{

    @BindView(R.id.popularMovieList)
    RecyclerView popularMovieRecyclerView;

    @BindView(R.id.popularTVList)
    RecyclerView popularTVRecyclerView;

    PopularMoviesListAdapter popularMovieListAdapter;
    PopularTVListAdapter popularTVListAdapter;

    @Inject
    HomeFragmentPresenter presenter;

    //TODO: get new instance for this



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_frag, container, false);
        ButterKnife.bind(this, rootView);


        //setup popular movie list
        LinearLayoutManager popularMovieLayoutManager = new LinearLayoutManager(getActivity());
        popularMovieLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        popularMovieRecyclerView.setLayoutManager(popularMovieLayoutManager);

        popularMovieListAdapter = new PopularMoviesListAdapter(getActivity());
        popularMovieRecyclerView.setAdapter(popularMovieListAdapter);


        //setup popular tv list
        LinearLayoutManager popularTVLayoutManager = new LinearLayoutManager(getActivity());
        popularTVLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        popularTVRecyclerView.setLayoutManager(popularTVLayoutManager);

        popularTVListAdapter = new PopularTVListAdapter((getActivity()));
        popularTVRecyclerView.setAdapter(popularTVListAdapter);

        //presenter.callPopularMovies();
        //presenter.callPopularTV();


        return rootView;
    }


    @Override
    public void updatePopularMovieList(ArrayList<PopularMoviesResults> results){
        popularMovieListAdapter.setResults(results);
    }

    @Override
    public void updatePopularTVList(ArrayList<PopularTVResults> results) {
        popularTVListAdapter.setResults(results);
    }
}
