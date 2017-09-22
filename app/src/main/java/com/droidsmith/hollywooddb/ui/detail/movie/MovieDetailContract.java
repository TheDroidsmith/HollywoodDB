package com.droidsmith.hollywooddb.ui.detail.movie;


import com.droidsmith.hollywooddb.data.remote.response.tmdb.movies.MovieDetails;

public interface MovieDetailContract {

    interface MovieDetailView{
        void setBasicInfo(MovieDetails movieDetails);
    }

    interface MovieDetailPresenter{
        void fetchBasicInfo(Integer movieID);
    }

}
