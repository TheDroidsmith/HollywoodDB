package com.droidsmith.hollywooddb.ui.detail.movie;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;
import com.droidsmith.hollywooddb.data.remote.response.tmdb.people.Cast;

import java.util.List;

public interface MovieDetailContract {

    interface MovieDetailView{
        void setBasicInfo(MovieDetails movieDetails);
        void setCastList(List<Cast> cast);
    }

    interface MovieDetailPresenter{
        void fetchBasicInfo(Integer movieID);
        void fetchCast(Integer movieID);
    }

}
