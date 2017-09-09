package com.droidsmith.hollywooddb.ui.home.fragments.home;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.Result;

import java.util.ArrayList;

public interface HomeFragmentView {

    void updateAdapter(ArrayList<Result> results);

}
