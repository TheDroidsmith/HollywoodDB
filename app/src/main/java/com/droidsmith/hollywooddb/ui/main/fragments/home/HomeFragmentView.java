package com.droidsmith.hollywooddb.ui.main.fragments.home;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.PopularMoviesResults;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.tv.PopularTVResults;

import java.util.ArrayList;

public interface HomeFragmentView {

    void updatePopularMovieList(ArrayList<PopularMoviesResults> results);
    void updatePopularTVList(ArrayList<PopularTVResults> results);

}
