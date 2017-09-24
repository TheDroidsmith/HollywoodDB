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
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShow;
import com.droidsmith.hollywooddb.ui.adapters.MovieListAdapter;
import com.droidsmith.hollywooddb.ui.adapters.TVShowListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;


public class HomeFragment extends Fragment implements HomeContract.HomeView {

    Unbinder unbinder;


    @BindView(R.id.popularMovieList)
    RecyclerView popularMovieRecyclerView;

    @BindView(R.id.popularTVList)
    RecyclerView popularTVRecyclerView;

    MovieListAdapter popularMovieListAdapter;
    TVShowListAdapter popularTVListAdapter;

    @Inject
    HomeContract.HomePresenter presenter;

    public static HomeFragment newInstance(){

        HomeFragment fragment = new HomeFragment();

        //If fragment needs anything, use this here and
        //use getArguments in onCreate()
        //Bundle args = new Bundle();
        //fragment.setArguments(args);

        return fragment;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getArguments() if any
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
        unbinder = ButterKnife.bind(this, rootView);

        //setup popular movie list
        LinearLayoutManager popularMovieLayoutManager = new LinearLayoutManager(getActivity());
        popularMovieLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        popularMovieRecyclerView.setLayoutManager(popularMovieLayoutManager);

        popularMovieListAdapter = new MovieListAdapter(getActivity());
        popularMovieRecyclerView.setAdapter(popularMovieListAdapter);

        //setup popular tv list
        LinearLayoutManager popularTVLayoutManager = new LinearLayoutManager(getActivity());
        popularTVLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        popularTVRecyclerView.setLayoutManager(popularTVLayoutManager);

        popularTVListAdapter = new TVShowListAdapter((getActivity()));
        popularTVRecyclerView.setAdapter(popularTVListAdapter);

        presenter.fetchPopularMoviesList();
        presenter.fetchPopularTVList();

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void updatePopularMovieList(List<Movie> results){
        popularMovieListAdapter.setResults(results);
    }

    @Override
    public void updatePopularTVList(List<TVShow> results) {
        popularTVListAdapter.setResults(results);
    }
}
