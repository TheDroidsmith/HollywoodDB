package com.droidsmith.hollywooddb.ui.main.fragments.movies;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;

import java.util.List;

public interface MoviesContract {

    interface MoviesView {

        void updateNewestMoviesList(List<Movie> results);

        void updateTopRatedMoviesList(List<Movie> results);

        void updateUpcomingMoviesList(List<Movie> results);

        void updateNowPlayingMoviesList(List<Movie> results);

    }

    interface MoviesPresenter {

        void fetchLatestMoviesList();

        void fetchTopRatedMoviesList();

        void fetchNowPlayingMoviesList();

        void fetchUpcomingMoviesList();

        void stop();
    }

}
