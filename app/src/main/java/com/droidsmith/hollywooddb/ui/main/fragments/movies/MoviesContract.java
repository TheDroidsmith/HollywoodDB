package com.droidsmith.hollywooddb.ui.main.fragments.movies;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;

import java.util.List;

public interface MoviesContract {

    interface MoviesView {

        void updateNewestMoviesList(List<Movie> results);

        void updateClassicMoviesList(List<Movie> results);

        void updateHighestRatedMoviesList(List<Movie> results);

        void updateUpcomingMoviesList(List<Movie> results);

    }

    interface MoviesPresenter {

        void fetchLatestMoviesList();

        void fetchHighestRatedMoviesList();

        void fetchUpcomingMoviesList();

        void fetchClassicMoviesList();
    }

}
