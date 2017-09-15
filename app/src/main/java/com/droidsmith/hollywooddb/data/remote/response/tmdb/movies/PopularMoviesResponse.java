package com.droidsmith.hollywooddb.data.remote.response.tmdb.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularMoviesResponse {
    @SerializedName("results")
    @Expose
    public List<Movie> results = null;

}