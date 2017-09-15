package com.droidsmith.hollywooddb.ui.main.fragments.home;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShow;

import java.util.List;

public interface HomeContract {

    interface HomePresenter {

        void fetchPopularMoviesList();

        void fetchPopularTVList();

        void fetchTopTVList();

        void stop();

    }

    interface HomeView {

        void updatePopularMovieList(List<Movie> results);

        void updatePopularTVList(List<TVShow> results);

    }

}
