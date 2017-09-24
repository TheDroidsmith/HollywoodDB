package com.droidsmith.hollywooddb.ui.main.fragments.movies;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidsmith.hollywooddb.R;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.ui.adapters.MovieListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;


public class MoviesFragment extends Fragment implements MoviesContract.MoviesView {

    Unbinder unbinder;

    @BindView(R.id.newestMoviesList)
    RecyclerView newestMoviesRecyclerView;

    @BindView(R.id.highestRatedList)
    RecyclerView highestRatedMoviesRecyclerView;

    @BindView(R.id.upcomingMoviesList)
    RecyclerView upcomingMoviesRecyclerView;

    @BindView(R.id.nowPLayingMoviesList)
    RecyclerView nowPlayingMoviesRecyclerView;

    MovieListAdapter newestMoviesAdapter, highestRatedMoviesAdapter,
            upcomingMoviesAdapter, nowPlayingAdapter;

    @Inject
    MoviesContract.MoviesPresenter presenter;

    public static MoviesFragment newInstance() {
        MoviesFragment fragment = new MoviesFragment();
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.movies_frag, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        setupUpcoming();
        setupHighestRated();
        setupNewest();
        setupNowPlaying();

        //call api
        fetchData();


        return rootView;
    }



    private void setupNowPlaying(){
        LinearLayoutManager nowPlayingLayoutManager = new LinearLayoutManager(getActivity());
        nowPlayingLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        nowPlayingMoviesRecyclerView.setLayoutManager(nowPlayingLayoutManager);

        nowPlayingAdapter = new MovieListAdapter(getActivity());
        nowPlayingMoviesRecyclerView.setAdapter(nowPlayingAdapter);
    }
    private void setupHighestRated(){
        LinearLayoutManager highestRatedLayoutManager = new LinearLayoutManager(getActivity());
        highestRatedLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        highestRatedMoviesRecyclerView.setLayoutManager(highestRatedLayoutManager);

        highestRatedMoviesAdapter = new MovieListAdapter(getActivity());
        highestRatedMoviesRecyclerView.setAdapter(highestRatedMoviesAdapter);
    }
    private void setupUpcoming(){
        LinearLayoutManager upcomingMoviesLayoutManager = new LinearLayoutManager(getActivity());
        upcomingMoviesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        upcomingMoviesRecyclerView.setLayoutManager(upcomingMoviesLayoutManager);

        upcomingMoviesAdapter = new MovieListAdapter(getActivity());
        upcomingMoviesRecyclerView.setAdapter(upcomingMoviesAdapter);
    }
    private void setupNewest(){
        LinearLayoutManager newestMoviesLayoutManager = new LinearLayoutManager(getActivity());
        newestMoviesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        newestMoviesRecyclerView.setLayoutManager(newestMoviesLayoutManager);

        newestMoviesAdapter = new MovieListAdapter(getActivity());
        newestMoviesRecyclerView.setAdapter(newestMoviesAdapter);
    }


    private void fetchData() {
        //presenter.fetchLatestMoviesList(); //api returning null
        presenter.fetchUpcomingMoviesList();
        presenter.fetchTopRatedMoviesList();
        presenter.fetchNowPlayingMoviesList();
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
    public void updateNewestMoviesList(List<Movie> results) {
        newestMoviesAdapter.setResults(results);
    }

    @Override
    public void updateTopRatedMoviesList(List<Movie> results) {
        highestRatedMoviesAdapter.setResults(results);
    }

    @Override
    public void updateUpcomingMoviesList(List<Movie> results) {
        upcomingMoviesAdapter.setResults(results);
    }

    @Override
    public void updateNowPlayingMoviesList(List<Movie> results) {
        nowPlayingAdapter.setResults(results);
    }



}
