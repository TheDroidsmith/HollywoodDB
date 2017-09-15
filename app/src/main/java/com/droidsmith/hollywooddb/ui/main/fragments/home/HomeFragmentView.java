package com.droidsmith.hollywooddb.ui.main.fragments.home;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Movie;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.TVShow;

import java.util.ArrayList;
import java.util.List;

public interface HomeFragmentView {

    void updatePopularMovieList(List<Movie> results);
    void updatePopularTVList(List<TVShow> results);

}
