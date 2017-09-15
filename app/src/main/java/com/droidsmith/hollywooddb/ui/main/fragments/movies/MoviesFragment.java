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
import com.droidsmith.hollywooddb.ui.main.adapters.MovieListAdapter;

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

    @BindView(R.id.classicMoviesList)
    RecyclerView classicMoviesRecyclerView;

    MovieListAdapter newestMoviesAdapter, highestRatedMoviesAdapter,
            upcomingMoviesAdapter, classicMoviesAdapter;

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

        setupRecyclerViews();

        //call api
        fetchData();


        return rootView;
    }

    private void fetchData() {
        //presenter.fetchLatestMoviesList();//api returning null
        presenter.fetchUpcomingMoviesList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    private void setupRecyclerViews(){
        //setup newest movies LayoutManager
        LinearLayoutManager newestMoviesLayoutManager = new LinearLayoutManager(getActivity());
        newestMoviesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        newestMoviesRecyclerView.setLayoutManager(newestMoviesLayoutManager);

        //setup upcoming movies LayoutManager
        LinearLayoutManager upcomingMoviesLayoutManager = new LinearLayoutManager(getActivity());
        upcomingMoviesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        upcomingMoviesRecyclerView.setLayoutManager(upcomingMoviesLayoutManager);

        //setup highest rated movies LayoutManager
        LinearLayoutManager highestRatedLayoutManager = new LinearLayoutManager(getActivity());
        highestRatedLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        highestRatedMoviesRecyclerView.setLayoutManager(highestRatedLayoutManager);

        //setup classic movies LayoutManager
        LinearLayoutManager classicLayoutManager = new LinearLayoutManager(getActivity());
        classicLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        classicMoviesRecyclerView.setLayoutManager(classicLayoutManager);

        //instantiate adapters
        newestMoviesAdapter = new MovieListAdapter(getActivity());
        highestRatedMoviesAdapter = new MovieListAdapter(getActivity());
        upcomingMoviesAdapter = new MovieListAdapter(getActivity());
        classicMoviesAdapter = new MovieListAdapter(getActivity());

        //assign adapters
        newestMoviesRecyclerView.setAdapter(newestMoviesAdapter);
        highestRatedMoviesRecyclerView.setAdapter(highestRatedMoviesAdapter);
        upcomingMoviesRecyclerView.setAdapter(upcomingMoviesAdapter);
        classicMoviesRecyclerView.setAdapter(classicMoviesAdapter);

    }


    @Override
    public void updateNewestMoviesList(List<Movie> results) {
        newestMoviesAdapter.setResults(results);
    }

    @Override
    public void updateHighestRatedMoviesList(List<Movie> results) {
        highestRatedMoviesAdapter.setResults(results);
    }

    @Override
    public void updateUpcomingMoviesList(List<Movie> results) {
        upcomingMoviesAdapter.setResults(results);
    }

    @Override
    public void updateClassicMoviesList(List<Movie> results) {
        classicMoviesAdapter.setResults(results);
    }
}
